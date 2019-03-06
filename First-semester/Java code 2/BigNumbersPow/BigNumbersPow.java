import java.math.*;
import java.util.*;

public class BigNumbersPow {
    public static void main (String[] args){
        Scanner in = new Scanner(System.in);
        
        System.out.print("Enter number: ");
        String n = in.next();

        BigInteger bi1 = new BigInteger(n);

        System.out.print("Enter power: ");
        int bi2 = in.nextInt();

        BigInteger bigPow = bi1.pow(bi2);

        System.out.println("Result: " + bigPow);

        in.close();
    }
}
/*
//Big Integer Examples

BigInteger bi1 = new BigInteger("3039768898793547264523745379249934"); 
BigInteger bi2 = new BigInteger("3039768898793547264523745379249934"); 

BigInteger bigSum = bi1.add(bi2);
BigInteger bigProduct = bi1.multiply(bi2);

System.out.println("Sum : " + bigSum);
System.out.println("Product : " + bigProduct);
*/