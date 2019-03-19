import java.util.Scanner;
import java.util.Arrays;

public class Binary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberToSearch, index;
        int[] numbers = {2, 8, 3, 9, 11, 45, 1, 34, 20, 92};

        Arrays.sort(numbers);
        numberToSearch = Integer.parseInt(sc.nextLine());

        //Sorted array, array length, number to search.
        index = binarySearch(numbers, numbers.length, numberToSearch);
        System.out.println(index);
    }
    public static int binarySearch(int[]numbers, int arrayLength, int search){
        int left, right, mid;
        //left side is the first position of the array
        left = 0;
        //right side is the last position of the array
        right = arrayLength-1;
    
        while(left < right){
            mid = (left+right)/2;
            if(numbers[mid] == search){
                return mid;
            }else if (numbers[mid] < search){
                left = mid + 1;
            }else{
                right = mid +1;
            }
        }
        return -1;
    }
}