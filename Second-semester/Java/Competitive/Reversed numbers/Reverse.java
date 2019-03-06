import java.util.Scanner;

public class Reverse{
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        String input, reversedIn;
        int t, i, n1, n2;
        //Enter the number of test cases
        t = sc1.nextInt();

        for(i = 0; i < t; i++){
            //Enter two numbers separated by an space 
            input = sc2.nextLine();
            reversedIn = reverseInput(input);

            n1 = Integer.parseInt(reversedIn.substring(0, reversedIn.indexOf(" ")));
            n2 = Integer.parseInt(reversedIn.substring(reversedIn.indexOf(" ") + 1));
            int result = n1 + n2;

            System.out.println(reverseInput(result + ""));
        }
        sc1.close();
        sc2.close();
    }
    public static String reverseInput(String input){
        String reversedIn = "";
        for(int i = input.length() - 1; i >= 0; i--){
            reversedIn += input.charAt(i);
        }
        return reversedIn;
    }
}