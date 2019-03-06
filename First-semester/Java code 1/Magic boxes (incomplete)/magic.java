public class magic {
    public static void main (String[] args){
    int i, caseline, tcases, n, x, s;

    System.out.print("Test cases: ");
    tcases = Integer.parseInt(System.console().readLine());

    for (i = 1 ; i <= tcases ; i++ ){
    
        System.out.println("Test case " + i + ":");
        caseline = Integer.parseInt(System.console().readLine());
        n = caseline().intAt(0);
        x = caseline().intAt(2);
        s = caseline().intAt(4);

        System.out.print("n: " + n);
        System.out.print("x: " + x);
        System.out.print("s: " + s);

    }



    }
}