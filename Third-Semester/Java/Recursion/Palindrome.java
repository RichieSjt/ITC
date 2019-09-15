import java.util.Scanner;

public class Palindrome{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a word to check if it is a palindrome: ");
        String word = sc.nextLine();
        System.out.println(isPalindrome(word) ? "It is a palindrome" : "It is not a palindrome");
    }
    public static boolean isPalindrome(String word){
        if(word.length() <= 1){
            return true;
        }else{
            if(word.charAt(0) == word.charAt(word.length() - 1))
                return isPalindrome(word.substring(1, word.length() - 1 ) );
            else
                return false;
        }
    }
}