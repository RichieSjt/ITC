import java.util.Scanner;

public class BigClock{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCases, i, left, right; ;
        String hour;

        testCases = Integer.parseInt(sc.nextLine());

        for(i = 0; i < testCases; i++){
            hour = sc.nextLine();

            left = Integer.parseInt(hour.substring(0, hour.indexOf(":")));
            right = Integer.parseInt(hour.substring(hour.indexOf(":")+1));

            if(right > 0){
                System.out.println(0);
            }else if(left <= 12){
                System.out.println(left+12);
            }else{
                System.out.println(left-12);
            }
        }
    }
}