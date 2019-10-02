import java.util.Scanner;

public class H {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int v = sc.nextInt();
        int n = sc.nextInt(); sc.nextLine();
        int total = v *n;
        for(int i = 1; i < 9; i++){
            int numero = total * i;
            System.out.print((numero/10 + (numero%10>0?1:0)) + " ");
        }
        System.out.println((total*9)/10 + ((total*9)%10>0?1:0));
        sc.close();
    }
}