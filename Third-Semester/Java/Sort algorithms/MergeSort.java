import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = randomArray();
        
        System.out.println("Array before sort: ");
		System.out.println(Arrays.toString(num));
        
        mergeSort(num, 0, num.length-1);

        System.out.println("\nArray after sort: ");
        System.out.println(Arrays.toString(num));

        sc.close();
    }

    public static void mergeSort(int[] num, int left, int right){
        //Base case: when left is not minor to right that means it is either the same or a higher number
        //This means that we have already divided our array until having a subarray of one item.
        if (left < right){
            int mid = (left + right)/2;
            mergeSort(num, left, mid);
            mergeSort(num, mid + 1, right);
            merge(num, left, mid, right);
        }
    }

    public static void merge(int[] num, int left, int mid, int right){
        int i, j, k;
        
        int[] tempArr = new int[num.length];
        
        //Duplicating the array into a temporal array
        for(i = left; i <= right; i++)
            tempArr[i] = num[i];
        
        i = left;
        j = mid + 1;
        k = left; 

        //Here we are merging two parts of the array
        while(i <= mid && j <= right){
            if(tempArr[i] <= tempArr[j]){
                num[k] = tempArr[i];
                i++;
            }
            else{
                num[k] = tempArr[j];
                j++;
            }
            k++;
        }
        
        //If there are items left in the subarray we must copy them into the target array
        while(i <= mid){
            num[k] = tempArr[i];
            k++;
            i++;
        }
            
        System.out.println("Subarrays after being merged: ");
        for(int m = left; m <= right; m++){
            System.out.println(num[m] + " ");
        }
    }

    public static int[] randomArray() {
        int[] arr = new int[10];

        for(int i = 0; i < arr.length; i++){
            arr[i] = (int)(Math.random()*100);
        }
        return arr;
    }
}