public class Soup{
    public static void main (String[] args){
        String names, p;
        int i, j; 
        String finalsoup[][] = new String[20][20]; 

        System.out.println("--Introduce 5 words to hide in the Soup separated by an space---");
        names = System.console().readLine();
        String Snames[] = names.split(" ");

            for(i = 0; i < Snames.length ; i++){
                String w = Snames[i];
                String o, coordinates;

                do{
                    int xy[] = Positions();
                    o = Orientation();
                    if (o.equals("horizontal")){
                        p = Posible(xy[0], w.length());
                        System.out.println("It is " + p + " to hide word " + (i+1) + ".");
                    }else{
                        p = Posible(xy[1], w.length());
                        System.out.println("It is " + p + " to hide word " + (i+1) + ".");
                    }
                    coordinates = String.valueOf(xy[0]) + " " + String.valueOf(xy[1]); 
                    System.out.println("Coordinates: " + coordinates);
                }while( p.equals("not posible") | p.equals("not posible") );
            
                finalsoup = write(o, w, coordinates);
            }

        for ( j = 0; j < 20 ; j++  ){
            for ( i = 0; i < 20 ; i++ ){
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

    public static int[] Positions(){
        int xy[] = new int [2];
        xy[0] = (int)(Math.random()*20);
        xy[1] = (int)(Math.random()*20);
        return xy;
    }

    public static String Orientation(){
        String or;
        int a = (int)(Math.random()*2);
        if (a == 0){
            or = "horizontal";
        }else{
            or = "vertical";
        }
        return or;
    }

    public static String Posible(int pos, int wordlen){
        String yn;
        if(pos + wordlen <= 20){
            yn = "posible";
        }else{
            yn = "not posible";
        }        
        return yn; 
    } 

    public static String[][] write(String orientation, String word, String coordinates){

        String print[][] = new String[20][20];
        char[] letters;
        String[] Sletters = new String[word.length()];
        int x, y, i, j;

        String xy[] = coordinates.split(" ");   
        int xyint[];
        xyint = new int [2];

        for ( i= 0; i < xy.length; i++){
            int a = Integer.parseInt(xy[i]);
            xyint[i] = a;
        }

        int posx = xyint[0] + word.length();
        int posy = xyint[1] + word.length();

        letters = word.toCharArray();
        for ( i= 0; i < letters.length; i++){
            String s = String.valueOf(letters[i]);
            Sletters[i] = s;
        }

        if(orientation.equals("horizontal")){
            y = xyint[1]; 
            for(x = xyint[0], j = 0 ; x < posx && j < Sletters.length ; x++ , j++ ){
                
                    print[x][y] = Sletters[j]; 
            
            }
        }else{
            x = xyint[0];
            for( y = xyint[1], j = 0;y < posy && j < Sletters.length ; y++, j++ ){
                
                    print[x][y] = Sletters[j];
                
            }
        }
        return print; 
    }
    
    public static String Rletter(){
        String l; int n; 
        String letters[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
         "s", "t", "u", "v", "w", "x", "y", "z"};
        n = (int)(Math.random()*26);
        l = letters[n];
        return l; 
    } 
    
}