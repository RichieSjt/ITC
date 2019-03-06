public class bio {
    public static void main (String[] args){
        
        double a, b, c, t, r;

            System.out.print("Enter the value of a: ");
            a = Double.parseDouble(System.console().readLine());

            System.out.print("Enter the value of b: ");
            b = Double.parseDouble(System.console().readLine());

            System.out.print("Enter the value of c: ");
            c = Double.parseDouble(System.console().readLine());

            System.out.print("Ealpsed days: ");
            t = Double.parseDouble(System.console().readLine());
            
            r = (a*(Math.pow(t, 2))+(b*t)+(c));
            System.out.println("Population prediction: " + r);

    }
}