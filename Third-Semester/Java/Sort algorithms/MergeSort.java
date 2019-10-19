import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = randomArray();
        
        System.out.println("Array before sort: ");
		System.out.println(Arrays.toString(num));
        
        merge();

        System.out.println("\nArray after sort: ");
        System.out.println(Arrays.toString(num));

        sc.close();
    }

    public static void merge(){

    }

    public static int[] randomArray() {
        int[] arr = new int[10];

        for(int i = 0; i < 10; i++){
            arr[i] = (int)(Math.random()*100);
        }
        return arr;
    }
}