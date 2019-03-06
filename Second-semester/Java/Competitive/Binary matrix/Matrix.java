import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrixSize, i, j, a, sum = 0, counter = 0;
        String input = "";
        String[] n; int[][] matrix = new int[99][99]; int[] num;
        boolean rowCheck = true;
        boolean columnCheck;

        do{
            matrixSize = Integer.parseInt(sc.nextLine());

            for(i = 0; i < matrixSize; i++){
                input += sc.nextLine() + " ";   
            }
            n = input.split(" ");
            num = new int[n.length];

            for(String x : n){
                a = Integer.parseInt(x);
                num[counter] = a; 
                counter++;
            }

            counter = 0;

            for(i = 0; i < matrixSize-1; i++){
                for(j = 0; j < matrixSize-1; j++){
                    matrix[i][j] = num[counter];
                    counter++;
                }
            }

            for(i = 0; i < matrixSize-1; i++){
                for(j = 0; j < matrixSize-1; j++){
                    System.out.println(matrix[i][j]);
                    a = matrix[i][j];
                    sum += a;
                }
                rowCheck &= (sum%2 == 0);
            }
            
            System.out.println(rowCheck);


            rowCheck = true;
            
        }while(matrixSize != 0);
        
    }
    /*
    public static boolean sumRow(String row){
        String[] n;
        int sum = 0, a;

        n = row.split(" ");

        for(String x: n){
            a = Integer.parseInt(x);
            sum += a;
        }
        return (sum%2 == 0);

    }*/

}