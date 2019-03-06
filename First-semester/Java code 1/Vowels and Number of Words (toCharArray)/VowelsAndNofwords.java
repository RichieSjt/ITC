public class VowelsAndNofwords {
    public static void main(String[]args) {
    String text; int length, i, vowelsc, y, wordsc;
    char[] vowels = {'a', 'e', 'i', 'o', 'u' };
    char[] letters;
    wordsc = 0;
    vowelsc = 0;
    
    System.out.print("Enter a text: ");
    text = System.console().readLine();
    length = text.length();
    letters = text.toCharArray();

    for (i = 0 ; i < length  ; i++){
        for(y = 0 ; y < 5 ; y++ ){
            if (vowels[y] == letters[i]){
                vowelsc = vowelsc + 1;
            }
        }
        if (letters[i] == ' '){
            wordsc = wordsc + 1;
        }
    }
    System.out.println("Number of vowels: " + vowelsc);
    System.out.println("Number of words: " + (wordsc + 1));
    }
}