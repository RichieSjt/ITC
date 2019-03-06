public class msquare{
    public static void main (String[]args){
        int[][] numbers = {{0,0,0}, {0,0,0}, {0,0,0}};
        int i, y, counter; counter = 0;
        int[] rows = {0, 0, 0};
        int[] columns = {0, 0, 0};

        for (i = 0; i < 3 ; i++ ){
            for (y = 0; y < 3 ; y++ ){
                System.out.print("Value at position " + i + ", " + y + ": ");
                numbers[i][y]= Integer.parseInt(System.console().readLine());

            }
        }
        
        System.out.println();

        for (i = 0; i < 3 ; i++ ){
            for (y = 0; y < 3 ; y++ ){
            System.out.print(numbers[i][y] + "\t");
            }
            System.out.println();
        }

        for(i = 0; i < 3 ; i ++ ){
            rows[i] = numbers[i][0] + numbers[i][1] + numbers[i][2];
            columns[i] = numbers[0][i] + numbers[1][i] + numbers[2][i];
            }

        for (i = 0; i < 3 ; i++ ){
            for (y = 0; y < 3 ; y++ ){
                if (rows[i]==columns[y]){
                counter = counter + 1;
                }
            }
        }
        System.out.println();
        
        if (counter == 9){
            System.out.println("It is a magic box");
        }else{
            System.out.println("It is not a magic box");
        }
    }
}
