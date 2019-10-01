import java.util.Scanner;

public class SelectionSort{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] num = {97, 12, 23, 3, 56, 6, 34, 78, 47, 10};
        
        System.out.println("Array before sort: ");
        for(int x : num){
            System.out.println(x);
        }

        System.out.println("\nArray after sort: ");
        selection(num);
        for(int x : num){
            System.out.println(x);
        }

        sc.close();

    }
    public static int[] selection(int[]num){
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
        return num;
    }
}