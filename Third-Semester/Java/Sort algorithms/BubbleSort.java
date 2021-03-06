import java.util.Scanner;
import java.util.Arrays;

public class BubbleSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = randomArray();
        
        System.out.println("Array before sort: ");
        System.out.println(Arrays.toString(num));

        bubble(num);
        
        System.out.println("\nArray after sort: ");
        System.out.println(Arrays.toString(num));

        sc.close();
    }
    
    public static void bubble(int[]num){
        boolean swapped;
        int temp;
        
        for(int i = 0; i < num.length-1; i++){
            swapped = false;
            for(int j = 0; j < num.length-1; j++){
                if(num[j] > num[j+1]){
                //Swapping the elements
                    temp = num[j+1];
                    num[j+1] = num[j];
                    num[j] = temp;
                    swapped = true;
                }
            }
            //Si ningun elemento se swappeo significa que la lista ya
            //está ordenada por lo tanto no es necesario continuar.
            if(!swapped)
                break;
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