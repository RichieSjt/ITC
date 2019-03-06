public class Darray{
    public static void main (String[]args){
        int[][] numbers;
        int NR, NC, i, y;

        System.out.print("Number of rows: ");
        NR= Integer.parseInt(System.console().readLine());

        System.out.print("Number of columns: ");
        NC= Integer.parseInt(System.console().readLine());

        numbers = new int [NR][NC];

        for (i = 0; i < NR ; i++ ){
            for (y = 0; y < NC ; y++ ){
                System.out.print("Value at position " + i + ", " + y + ": ");
                numbers[i][y]= Integer.parseInt(System.console().readLine());
            }
        }
        
        System.out.println();

        for (i = 0; i < NR ; i++ ){
            for (y = 0; y < NC ; y++ ){
            System.out.print(numbers[i][y] + "\t");
            }
            System.out.println();
        }

    }
}
