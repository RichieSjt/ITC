import java.util.Scanner;
import java.util.Arrays;

public class WeirdSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, testCases, temp;
        int[] array, swaps;
        boolean possible, swap;

        testCases = Integer.parseInt(sc.nextLine());
       
        for(i = 0; i < testCases; i++){
            possible = true;
            swap = true;
            array = new int[sc.nextInt()];
            swaps = new int[sc.nextInt()];

            for(j = 0; j < array.length; j++)
                array[j] = sc.nextInt();
            for(j = 0; j < swaps.length; j++)
                swaps[j] = sc.nextInt();

            Arrays.sort(swaps);
            
            while(swap){
                for(j = 0; j < swaps.length; j++){
                    swap = false;
                    
                    if(array[swaps[j] - 1] > array[swaps[j]]){
                        temp = array[swaps[j] - 1];
                        array[swaps[j] - 1] = array[swaps[j]];
                        array[swaps[j]] = temp;
                        swap = true;
                    }
                }
            }
            
            for(j = 0; j < array.length-1; j++)
                if(array[j] <= array[j+1])
                    possible &= true;
                else
                    possible &= false;
            
            System.out.println(possible ? "YES" : "NO");
        
        }
    }
}