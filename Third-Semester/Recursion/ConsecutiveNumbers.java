import java.util.Scanner; 

public class ConsecutiveNumbers{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Print sum of consecutive numbers until: ");
        int n = Integer.parseInt(sc.nextLine());

        System.out.println("Result: " + consecutive(n));
    }
    public static int consecutive(int n){
        if(n == 1)
            return 1;
        else       
            return n + consecutive(n-1);
    }
}