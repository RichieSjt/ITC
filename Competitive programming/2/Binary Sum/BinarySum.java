import java.util.Scanner;

public class BinarySum{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, j, t, n1, n2, sum, intCarry = 0;
        String bIn, b1, b2, result = "", carry = "";

        t = Integer.parseInt(sc.nextLine()); //Test cases

        for(i = 0; i < t; i++){
            bIn = sc.nextLine(); //Enter two binary numbers separated by an space

            b1 = bIn.substring(0, bIn.indexOf(" ")); //The first number splits
            b2 = bIn.substring(bIn.indexOf(" ")+1); // The second number splits
            
            for(j = b1.length()-1; j >= 0 ; j--) {
                n1 = Character.getNumericValue(b1.charAt(i));
                n2 = Character.getNumericValue(b2.charAt(i));

                sum = n1+n2+intCarry;
                intCarry = 0;

                if(j == 0){
                    carry = Integer.toBinaryString(sum);
                    result += carry;
                }else{
                    if(sum == 0){
                        result += "0";
                    }else if(sum == 1){
                        result += "1";
                    }else if(sum == 2){
                        result += "0";
                        intCarry = 1;
                    }else if(sum == 3){
                        carry = Integer.toBinaryString(sum);
                        result += "1";
                        intCarry = 1;
                    }
                }
                sum = 0;
            }
            
            System.out.println((i+1) + " " + result); //The result displays
        }
        sc.close();
    }
}
