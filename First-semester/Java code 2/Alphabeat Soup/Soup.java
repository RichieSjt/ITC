public class Soup{
    public static void main (String[] args){
        String input;
        int x = 0, y = 0;
        boolean possible;
        char[] letters;
        String finalsoup[][] = new String[20][20];

        System.out.println("//Enter the words to hide in the Soup separated by an space//");
        input = System.console().readLine();
        String WordsArray[] = input.split(" ");

        for(int i = 0; i < WordsArray.length ; i++){
            String word = WordsArray[i];
            String orientation = "";

            //The methods generate random positions and orientations
            //until they find valid ones to fit the word.
            possible = false;
            while(!possible){
                int xy[] = positions();
                x = xy[0];
                y = xy[1];

                orientation = orientation();
                if (orientation.equals("horizontal"))
                    possible = posible(x, word.length());
                else
                    possible = posible(y, word.length());
            }

            //The word is split into letters and stored in an array.
            letters = word.toCharArray();

            //x and y positions of the last letter of the word.
            int posx = x + word.length();
            int posy = y + word.length();

            int j;
            //Writing the letters into the finalSoup array depending
            //on the words orientation.
            if(orientation.equals("horizontal")){
                j = 0;
                while(x < posx && j < letters.length){   
                    finalsoup[x][y] = letters[j] + "";
                    x++;
                    j++;
                }
            }else{
                j = 0;
                while(y < posy && j < letters.length){
                    finalsoup[x][y] = letters[j] + "";
                    y++;
                    j++;
                }
            }
        }

        //Filling the blank spaces in the array and then printing it.
        for (int j = 0; j < 20 ; j++){
            for (int i = 0; i < 20 ; i++){
                if(finalsoup[i][j] == null){
                    finalsoup[i][j] = randomLetter();
                    System.out.print(finalsoup[i][j] + " ");
                }
                else{
                    System.out.print(finalsoup[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    //Checks if its possible to hide the word.
    public static boolean posible(int pos, int wordlen){
        boolean yn;
        //TODO: Check if a position we want to fill has already been filled to avoid overwriting it.
        if(pos + wordlen <= 20)
            yn = true;
        else
            yn = false;  
        return yn; 
    }

    //Returns random x and y position
    public static int[] positions(){
        int xy[] = new int [2];
        xy[0] = (int)(Math.random()*20);
        xy[1] = (int)(Math.random()*20);
        return xy;
    }
    
    //Returns a random orientation (horizontal/vertical).
    public static String orientation(){
        String or;
        int a = (int)(Math.random()*2);
        if (a == 0)
            or = "horizontal";
        else
            or = "vertical";
        return or;
    }
    
    //Returns a random letter.
    public static String randomLetter(){
        int n; 
        String l; 
        String letters[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
         "s", "t", "u", "v", "w", "x", "y", "z"};
        n = (int)(Math.random()*26);
        l = letters[n];
        return l; 
    } 
    
}