import java.util.Scanner;

public class Combos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, testCases;
        String[] alphabeat = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", 
        "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        int[] errors;

        testCases = Integer.parseInt(sc.nextLine());

        for(i = 0; i < testCases; i++){
            int n = sc.nextInt();
            int m = sc.nextInt();
            String combo = sc.nextLine();

            errors = new int[m];
            for(int j = 0; j < errors.length; j++){
                errors[j] = sc.nextInt();
            }
            for(int j = 0; j < errors.length; j++){
                System.out.println(combo.substring(0, errors[j]));
            }
        }
    }
}