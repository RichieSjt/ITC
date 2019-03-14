import java.util.Scanner;

public class Fractions {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, input, counter = 0;

        do{ 
            input = Integer.parseInt(sc.nextLine());

            for(i = 1; i < input; i++){
                if(gcd(i, input) == 1){
                    counter++;
                }
            }
            System.out.println(counter);
            counter = 0;
        }while(input != 0);
        
    }
    public static int gcd(int n, int m){
        if(m==0){
            return n;
        }else{
            return gcd(m, n%m);
        }
    }
}