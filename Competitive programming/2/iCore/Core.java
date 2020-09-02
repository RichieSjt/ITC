import java.util.Scanner;

public class Core {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, testCases;
        String input1, input2;
        boolean possible = true;

        do{
            testCases = Integer.parseInt(sc.nextLine());
            if(testCases != 0){
                for (i = 0; i < testCases/2 ; i++) {
                    input1 = sc.nextLine();
                    input2 = sc.nextLine();

                    possible &= compare(input1, input2);
                }

                if(possible == true)
                    System.out.println("YES");
                else
                    System.out.println("NO");
                    
                possible =  true;
            }else{
                break;
            }
        }while(testCases != 0);
    }

    public static boolean compare(String input1, String input2){
        int n1, n2, n3, n4;

        n1 = Integer.parseInt(input1.substring(0, input1.indexOf(" ")));
        n2 = Integer.parseInt(input1.substring(input1.indexOf(" ") + 1));
        n3 = Integer.parseInt(input2.substring(0, input2.indexOf(" ")));
        n4 = Integer.parseInt(input2.substring(input2.indexOf(" ") + 1));

        if(n1 == n4 && n2 == n3)
            return true;
        else
            return false;
    }
}