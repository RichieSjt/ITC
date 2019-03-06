import java.awt.print.Printable;

public class mod5 {
    public static void main(String[] args){
        int x, y, n;
        char[][] coordinates;
        coordinates = new char [121][121];

        for (x = 120; x >= 0 ; x--){
            for (y = 0; y <= 120 ; y++){
                n = x-y;
                if(x==120 && y == 0){
                    System.out.print("   -60                                                         0                                                          60");
                    System.out.println("");
                }
                
                if(y==0){
                    System.out.print(x-60 + " ");
                }
                
                if(n%5==0){
                    coordinates[x][y] = '*';
                    System.out.print(coordinates[x][y]);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println(" ");
            }
        }
    }