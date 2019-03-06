import java.util.Scanner;

public class forConDosPuntos{
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n;   

        System.out.print("How many numbers?: ");
        n = sc.nextInt();
        int[] numbers = new int[n];

        for(int i=0; i<n; i++ ){
            System.out.print("Number " + (i+1) + ": ");
            numbers[i] = sc.nextInt();
        }

        //Todo el contenido del array numbers se le va asignando a x hasta que ya no queden elementos.
        for(int x: numbers){
            System.out.println(x);
        }
        sc.close();
    }
}