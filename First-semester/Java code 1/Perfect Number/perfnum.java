public class perfnum {
    public static void main(String[] args){
        boolean result; int i, n;

        System.out.print("Enter a number: ");
        n = Integer.parseInt(System.console().readLine());

        System.out.println("Perfect numbers between the number: ");
        
        for(i = 2 ; i <= n ; i++){
            result = perfectNumber(i);
            if(result == true){
                System.out.println(i);
            }
        }
    }

    public static boolean perfectNumber(int n){
        int i, perfect;
        perfect = 1;

        for(i = 2 ; i <= Math.sqrt(n) ; i++){
            if(n % i == 0){
                perfect += i + n/i;
            }
        }
        return perfect == n; 
    }

}