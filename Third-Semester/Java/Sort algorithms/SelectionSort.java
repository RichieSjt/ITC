import java.util.Scanner;
import java.util.Arrays;

public class SelectionSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = randomArray();
        
        System.out.println("Array before sort: ");
        System.out.println(Arrays.toString(num));

        selection(num);
        
        System.out.println("\nArray after sort: ");
        System.out.println(Arrays.toString(num));

        sc.close();
    }
    
    public static void selection(int[]num){
        int temp, smallest;

        for(int i = 0; i < num.length-1; i++){
            smallest = i;
            for(int j = i + 1; j < num.length; j++){
                if(num[j] < num[smallest])
                    smallest = j;
            }
            temp = num[smallest];
            num[smallest] = num[i];
            num[i] = temp;
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