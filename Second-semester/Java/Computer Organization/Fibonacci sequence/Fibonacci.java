import java.math.BigInteger;

public class Fibonacci {
    public static void main(String[] args) {
        int limit, i;
        BigInteger f0 = new BigInteger("0"); 
        BigInteger f1 = new BigInteger("1"); 
        BigInteger fNumber = new BigInteger("0");

        System.out.println("Initial values F0 = 0, F1 = 1");
        System.out.print("\nPrint until fibonacci number: ");
        limit = Integer.parseInt(System.console().readLine());

        for (i = 1; i <= limit; i++) {
            fNumber = f0.add(f1);
            f0 = f1;
            f1 = fNumber;
            System.out.println("Number " + i + ": " + fNumber);
        }
    }
}