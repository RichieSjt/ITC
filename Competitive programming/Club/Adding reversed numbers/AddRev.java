import java.util.Scanner;

public class AddRev {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, testCases, n1, n2, result;

        testCases = Integer.parseInt(sc.nextLine());

        for(i = 0; i < testCases; i++){
            n1 = reverse(sc.nextInt());
            n2 = reverse(sc.nextInt());

            result = reverse(n1+n2);
            System.out.println(result);
        }
    }
    public static int reverse(int number){
        int reverse = 0;
        while(number != 0){
            reverse = reverse * 10;
            reverse = reverse + number%10;
            number = number/10;
        }
        return reverse;
    }
}