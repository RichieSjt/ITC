import java.util.Scanner; 

public class Factorial{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Print factorial of: ");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Result: " + factorial(n));
    }
    public static int factorial(int n){
        if(n == 0)
            return 1;
        else       
            return n * factorial(n-1);
    }
}