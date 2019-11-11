public class Soup{
    public static void main (String[] args){
        String names;
        int x = 0, y = 0;
        boolean possible = false;
        char[] letters;
        String finalsoup[][] = new String[20][20];

        System.out.println("--Introduce the words to hide in the Soup separated by an space---");
        names = System.console().readLine();
        String WordsArray[] = names.split(" ");

        for(int i = 0; i < WordsArray.length ; i++){
            String word = WordsArray[i];
            String orientation = "";

            //The methods generate random positions and orientations
            //until they find valid ones to fit the word.

            while(!possible){
                int xy[] = Positions();
                x = xy[0];
                y = xy[1];

                orientation = Orientation();
                if (orientation.equals("horizontal"))
                    possible = Posible(x, word.length());
                else
                    possible = Posible(y, word.length());
                    
            }

            int posx = x + word.length();
            int posy = y + word.length();

            //The word is split into letters and stored in an array
            letters = word.toCharArray();

            int j;
            if(orientation.equals("horizontal")){
                for(x = x, j = 0 ; x < posx && j < letters.length ; x++, j++)
                    finalsoup[x][y] = letters[j] + ""; 
            }else{
                for(y = y, j = 0; y < posy && j < letters.length ; y++, j++)
                    finalsoup[x][y] = letters[j] + "";
            }
        }

        //Filling the missing spaces in the array and printing it
        for (int j = 0; j < 20 ; j++){
            for (int i = 0; i < 20 ; i++){
                if(finalsoup[i][j] == null){
                    finalsoup[i][j] = Rletter();
                    System.out.print(finalsoup[i][j] + " ");
                }
                else{
                    System.out.print(finalsoup[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    //Checks if its possible to hide the word
    public static boolean Posible(int pos, int wordlen){
        boolean yn;
        if(pos + wordlen <= 20){
            yn = true;
        }else{
            yn = false;
        }        
        return yn; 
    }

    //Returns random x and y position
    public static int[] Positions(){
        int xy[] = new int [2];
        xy[0] = (int)(Math.random()*20);
        xy[1] = (int)(Math.random()*20);
        return xy;
    }
    
    //Returns a random orientation (horizontal/vertical)
    public static String Orientation(){
        String or;
        int a = (int)(Math.random()*2);
        if (a == 0)
            or = "horizontal";
        else
            or = "vertical";
        return or;
    }
    
    //Returns a random letter
    public static String Rletter(){
        int n; 
        String l; 
        String letters[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
         "s", "t", "u", "v", "w", "x", "y", "z"};
        n = (int)(Math.random()*26);
        l = letters[n];
        return l; 
    } 
    
}