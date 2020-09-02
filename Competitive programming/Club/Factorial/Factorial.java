import java.util.Scanner;
import java.lang.Math;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, n = 0, testCases, number, result = 0;

        testCases = Integer.parseInt(sc.nextLine());

        for(i = 0; i < testCases; i++){

            number = sc.nextInt();
            result += number/5;
            
            while(Math.pow(5, n) != number){
                n = (int)(Math.log(number) / Math.log(5)); // get n = log5(x), truncated to integer
                number--;
            }
                        
            System.out.println("Closest power of n: " + n);
            result += n-1;
            System.out.println(result);
        }
    }
}