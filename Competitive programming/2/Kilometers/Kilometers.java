public class Kilometers {
    public static void main(String[] args) {
        long x, d = 0, r = -1;

        System.out.print("Test cases: ");
        int t = Integer.parseInt(System.console().readLine());

        for (int i = 0; i < t; i++) {

            System.out.print("Enter x: ");
            x = Long.parseLong(System.console().readLine());

            for (long n = 2; r != 0; n++) {
                r = (x - ((n * (n - 1)) / 2)) % n; //Comprueba si es entero cuando r = 0; 
                d = (x - ((n * (n - 1)) / 2)) / n; //Guarda el valor de d
                
            }
            System.out.println("Result: " + d);
            d = 0;
        }
    }
}