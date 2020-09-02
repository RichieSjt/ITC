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
            }else if ((right == left) && (jumps % 2 != 0)){
                result = right;
            }else if (jumps % 2 == 0){
                result = (right - left) * (jumps/2);
            }else if (jumps % 2 != 0){
                result = (right - left) * (jumps/2) + right;
            }

            System.out.println(result);
            result = 0;
        }
    }
}