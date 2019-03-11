import java.util.Scanner;

public class Frog {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, queries;
        long right, left, jumps, result = 0;
        String input;

        queries = Integer.parseInt(sc.nextLine());

        for (i = 0; i < queries; i++) {
            input = sc.nextLine();

            right = Long.parseLong(input.substring(0, input.indexOf(" ")));
            left = Long.parseLong(input.substring(input.indexOf(" ") + 1, input.lastIndexOf(" ")));
            jumps = Long.parseLong(input.substring(input.lastIndexOf(" ") + 1));

            if ((right == left) && (jumps % 2 == 0)){
                result = right - left;
                System.out.println(result);
            }else if ((right == left) && (jumps % 2 != 0)){
                result = (2 * right) - left;
                System.out.println(result);
            }else {
                for (j = 1; j <= jumps; j++) {
                    if (j % 2 == 0)
                        result -= left;
                    else
                        result += right;
                }
                System.out.println(result);
            }
            result = 0;
        }
    }
}