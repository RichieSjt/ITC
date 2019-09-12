import java.util.Scanner;

public class Fibonacci{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Print until fibonacci number: ");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Result: " + fibonacci(n));
        sc.close();
        
    }
    public static int fibonacci(int n){
        if(n <= 1)
            return n;
        return fibonacci(n-1) + fibonacci(n-2);
    }
}