import java.util.*;

public class Universe{
    public static void main(String[] args) {    
        Scanner sc = new Scanner(System.in);

        int input = 0;

        while(input != 42){
            input = sc.nextInt();
            if(input == 42){
                break;
            }
            System.out.println(input); 
        }
    }
}