import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int matrixSize, i;
        String matrixRow;
        boolean rowCheck = true;
        boolean columnCheck;

        do{
            matrixSize = Integer.parseInt(sc.nextLine());

            for(i = 0; i < matrixSize; i++){
                matrixRow = sc.nextLine();
                rowCheck &= sumRow(matrixRow);
                sumColumn(matrixRow, matrixSize);
            }
            if(rowCheck == true)
                System.out.println("OK");
            else
                System.out.println("Corrupt");

            rowCheck = true;
        }while(matrixSize != 0);

    }
    public static boolean sumRow(String row){
        String[] n;
        int sum = 0, a;

        n = row.split(" ");

        for(String x: n){
            a = Integer.parseInt(x);
            sum += a;
        }
        return (sum%2 == 0);

    }
    public static int sumColumn(String column, int matrixSize){
        int i = 0;
        return i;
    }
} 