public class wordslen {
    
    public static void main (String[] args){
    String word, wordL;
    int length, i, longest;
    longest = Integer.MAX_VALUE;

    longest = 0; wordL = ""; 
    
        for ( i = 1 ; i <= 10  ; i++ ){   
    
            System.out.print("Word " + i + ": ");
            word = System.console().readLine();
            length = word.length();    

            if (length>longest){
                longest = length;
                wordL = word;
            }
        }

        System.out.println("The longest word is " + longest + " characters long and it is: " + wordL);
        
    }
}