import java.util.Scanner;

public class BinarySum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, t, r1, r2;
        String bIn, b1, b2;

        t = Integer.parseInt(sc.nextLine()); //Test cases

        for(i = 0; i < t; i++){
            bIn = sc.nextLine(); //Enter two binary numbers separated by an space

            b1 = bIn.substring(0, bIn.indexOf(" ")); //The first number splits
            b2 = bIn.substring(bIn.indexOf(" ")+1); // The second number splits
            
            r1 = Integer.parseInt(b1, 2); //The binary String is converted to decimal int  
            r2 = Integer.parseInt(b2, 2);

            String result = Integer.toBinaryString(r1+r2); //The int sum is converted to a binary string

            System.out.println((i+1) + " " + result); //The result displays
        }
        sc.close();
    }
}

