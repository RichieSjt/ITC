public class mrua {
    public static void main (String[] args){
    double t, speed, angle, sen, cos, rad, tf, x, y, xf, yf, g = 9.81;
    char exit;

    do{
    System.out.print("Initial speed: ");
    speed= Integer.parseInt(System.console().readLine());

    System.out.print("Angle: ");
    angle= Integer.parseInt(System.console().readLine());

    rad = (angle/180) * Math.PI;
    sen = rad - ((Math.pow(rad, 3))/6) + ((Math.pow(rad, 5))/120) - ((Math.pow(rad, 7))/5040);
    cos = 1 - ((Math.pow(rad, 2))/2) + ((Math.pow(rad, 4))/24) - ((Math.pow(rad, 6))/720);

    tf= ((speed*sen)/g)*2;
    System.out.println("");

    System.out.print("Time" + "\t " + "x   " + "\t " + "y" + "\t ");
    System.out.println("");

        for (t = 0 ; t <= tf ; t++){
        x=(speed*cos)*t;
        y=((speed*sen)*t)-(g*Math.pow(t,2))/2;

        y = Math.round(y * 100);    y = y/100;           
        x = Math.round(x * 100);    x = x/100;

        System.out.print(t + "\t " + x + "\t " + y + "\t ");
        System.out.println();
        }
        System.out.println("");

        xf=(speed*cos)*tf;
        yf=((speed*sen)*tf)-((g*Math.pow(tf,2))/2);
        System.out.println("The time it will take to fall again is: " + tf + " seconds");
        System.out.println("Final position in x: " + xf + " meters");
        System.out.println("Final position in y: " + yf + " meters");

        System.out.println("");
        System.out.println("Enter any key to perform another operation, introduce ! to exit");
        exit = System.console().readLine().charAt(0);
        System.out.println("");

    }while (exit != '!');

    }
}