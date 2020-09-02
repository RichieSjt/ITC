import java.util.Scanner;

public class AddSubstract {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, testCases, a, b, result;

        testCases = Integer.parseInt(sc.nextLine());

        for(i = 0; i < testCases; i++){
            a = sc.nextInt();
            b = sc.nextInt();

            if(a > b)
                result = ((a-b)%2==0) ? 1 : 2;
            else if(a < b)
                result = ((b-a)%2==0) ? 2 : 1;
            else
                result = 0;
            
            System.out.println(result);
        }
    }
}