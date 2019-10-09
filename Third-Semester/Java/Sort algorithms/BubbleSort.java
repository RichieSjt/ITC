import java.util.Scanner;

public class BubbleSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = {345, 56, 23, 3, 7, 2, 34, 78, 47, 1};
        
        System.out.println("Array before sort: ");
        for(int x : num){
            System.out.println(x);
        }

        System.out.println("\nArray after sort: ");
        bubble(num);
        for(int x : num){
            System.out.println(x);
        }

        sc.close();

    }
    public static int[] bubble(int[]num){
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
        return num;
    }

}