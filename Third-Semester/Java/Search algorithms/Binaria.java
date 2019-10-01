import java.util.Scanner;
import java.util.Arrays;

public class Binaria{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //The array must be sorted in order to make binary search
        int[] num = {2, 5, 7, 12, 19, 34, 39, 46, 50, 59, 62};

        System.out.print("Enter the number to search in the array: ");
        int toSearch = Integer.parseInt(sc.nextLine());
        
        int index = binarySearch(num, toSearch);
        System.out.println("The number is in the index: " + index);

        sc.close();
    }
    public static int binarySearch(int[] num, int toSearch){
        int start = 0;
        int end = num.length-1;
        int mid;

        while(start <= end){
            mid = (start + end)/2;
            if(num[mid] == toSearch)
                return mid;
            if(num[mid] < toSearch)
                start = mid + 1;
            else
                end = mid - 1; 
        }
        return -1;
    }
}