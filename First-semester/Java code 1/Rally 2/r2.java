import java.util.Scanner;
import java.io.File;

public class r2 {
    public static void main(String[] args) throws Exception{
        

        int[][] coordinates;

        coordinates = new int [100][20];

        Scanner sc = new Scanner (new File("magicCoordinates.txt"));
        int x, y;

        while (sc.hasNext()){
        x = sc.nextInt();
        y = sc.nextInt();
        coordinates[x][y] = '1';
        }

        for (int i = 0; i < 100 ; i++ ){
            for (int j = 0; j < 20 ; j++ ){
                if (coordinates[i][j] != 0){
                    System.out.print(coordinates[i][j]);
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
    }
}


