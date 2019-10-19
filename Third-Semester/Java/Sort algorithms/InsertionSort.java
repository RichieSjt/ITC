import java.util.Scanner;
import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = randomArray();
        
        System.out.println("Array before sort: ");
        System.out.println(Arrays.toString(num));

        insertion(num);

        System.out.println("\nArray after sort: ");
        System.out.println(Arrays.toString(num));

        sc.close();
    }
    
    public static void insertion(int[] num) {
        int i, j, temp;
        i = 1;
        while(i < num.length){
            j = i;
            while((j > 0) && num[j-1] > num[j]){
                //Swapping the elements
                temp = num[j-1];
                num[j-1] = num[j];
                num[j] = temp;

                j--;
            }
            i++;
        }
        //end
    }

    public static int[] randomArray() {
        int[] arr = new int[10];

        for(int i = 0; i < 10; i++){
            arr[i] = (int)(Math.random()*100);
        }
        return arr;
    }
}