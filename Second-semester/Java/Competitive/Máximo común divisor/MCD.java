public class MCD{
    public static void main(String[] args) {
        int n, m, r = 0; 

        System.out.print("Enter n: " );
        n = Integer.parseInt(System.console().readLine());

        System.out.print("Enter m: " );
        m = Integer.parseInt(System.console().readLine());
            
        r = gcd(n, m);

        System.out.print("The greatest common divisor is: " + r );

        
    }
    public static int gcd(int n, int m){
        if(m==0){
            return n;
        }else{
            return gcd(m, n%m);
        }
    }
}