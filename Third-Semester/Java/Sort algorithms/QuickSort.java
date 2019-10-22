import java.util.Scanner;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = randomArray();
        
        System.out.println("Array before sort: ");
		System.out.println(Arrays.toString(num));
        
        quick(num, 0, num.length-1);

        System.out.println("\nArray after sort: ");
        System.out.println(Arrays.toString(num));

        sc.close();
    }

    public static void quick(int[] num, int left, int right) {
        int mid = (right + left)/2;
        int pivote = num[mid];

        int i = left;
        int j = right;

        while (i <= j){
            while (num[i] < pivote)
                i++;
            
            while (num[j] > pivote)
                j--;
            
            if (i <= j){
                int temp = num[i];
                num[i] = num[j];
                num[j] = temp;
                
                i++;
                j--;
            }
        }

        if(left < j)
            quick(num, left, j);

        if(i < right)
            quick(num, i, right);
    }

    public static int[] randomArray() {
        int[] arr = new int[10];

        for(int i = 0; i < 10; i++){
            arr[i] = (int)(Math.random()*100);
        }
        return arr;
    }
}