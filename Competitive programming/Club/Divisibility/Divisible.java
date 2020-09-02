import java.util.Scanner;

public class Divisible {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, testCases, n, x, y, number;

        testCases = Integer.parseInt(sc.nextLine());

        for(i = 0; i < testCases; i++){
            n = sc.nextInt();
            x = sc.nextInt();
            y = sc.nextInt();

            number = x;

            while(number < n){
                if(number%x == 0 && number%y != 0)
                    System.out.print(number + " ");
                number++;
            }
            System.out.println("");
        }
    }
}