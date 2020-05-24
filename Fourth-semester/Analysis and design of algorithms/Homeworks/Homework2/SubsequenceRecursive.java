import java.util.Scanner;

public class SubsequenceRecursive {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String x = sc.next();
        String y = sc.next();

        System.out.println(longestSubsequence(x, y));
        sc.close();
        
    }

    public static int longestSubsequence(String x, String y){
        if(x.length() <= 0 || y.length() <= 0){
            return 0;
        }else{
            if(x.charAt(0) == y.charAt(0))
                return 1 + longestSubsequence(x.substring(1), y.substring(1));
            else{
                int a = longestSubsequence(x.substring(1), y);
                int b = longestSubsequence(x, y.substring(1));
                return Math.max(a, b);
            }
        }
    }
}