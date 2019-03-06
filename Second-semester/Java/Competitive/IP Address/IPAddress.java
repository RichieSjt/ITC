import java.util.Scanner;

public class IPAddress{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] Addresses;
        String result = "";

        System.out.print("Enter an IP Address: ");
        String ip = sc.nextLine();

        Addresses = ip.split("\\.");
        int[] AddressesInt = new int[Addresses.length];

        for(int i = 0; i < Addresses.length ; i++){
            int a = Integer.parseInt(Addresses[i]);
            AddressesInt[i] = a;
        }
        String zeros = "00000000";
        for(int j = 0; j < AddressesInt.length ; j++){
            int n = AddressesInt[j];
            String b = BinaryNumber(n);
            result += zeros.substring(0, 8-b.length()) + b + " "; 
        }
        System.out.println("Converted to binary: " + result);
        sc.close();
    }
    public static String BinaryNumber(int number){
        if(number/2 == 0){
            return number + ""; 
        }else{
            return BinaryNumber(number/2) + "" + number%2;
        }
    }
}