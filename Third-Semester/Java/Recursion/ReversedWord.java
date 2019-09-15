import java.util.Scanner;

public class ReversedWord{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Palabra a invertir: ");
        String word = sc.nextLine();

        System.out.println("La palabra invertida es: " + reverse(word));
    }
    public static String reverse(String word){
        if(word.length() == 1)
            return word;
        else
            return reverse(word.substring(1)) + word.charAt(0);
        
    }
}