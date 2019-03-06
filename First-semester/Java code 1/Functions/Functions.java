import java.util.Scanner;

public class Functions{
    public static void main (String[]args){
        Scanner sc = new Scanner(System.in);
        helloWorld();
        helloYou("Richie");
        helloYou(args[0]);
        helloYou(System.console().readLine());
        helloYou(sc.next());
        int vowels = countVowels(sc.next());
        System.out.println("Number of vowels: " + vowels);
        int spaces = countSpaces(System.console().readLine());
        System.out.println("Number of spaces: " + spaces);
    }
    public static void helloWorld(){
        System.out.println("Hello World!");
    }
    public static void helloYou(String name){
        System.out.println("Hello " + name);
    }
    public static int countVowels(String text){
        int counter, i;
        char[] letters;
        counter = 0;
        letters = text.toCharArray();

        for(i = 0; i < text.length() ; i++){
            if(letters[i] == 'a' | letters[i] == 'e' | letters[i] == 'i' | letters[i] == 'o' | letters[i] == 'u'){
                counter = counter + 1;
                //counter++
            }
        }
        return counter;
    }

    public static int countSpaces(String space){
        int i, counter;
        char[] letters;
        counter = 0; 
        letters = space.toCharArray();
        
        for(i = 0; i < space.length() ; i++){
            if (letters[i] == ' '){
                counter = counter + 1;
            }
        }
        return counter;
    }
    
}