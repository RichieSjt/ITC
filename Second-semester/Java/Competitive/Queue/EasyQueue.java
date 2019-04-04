import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class EasyQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, testCases;
        String input;
        Queue<String> q = new LinkedList<>();

        testCases = Integer.parseInt(sc.nextLine());

        for(i = 0; i < testCases; i++){
            input = sc.nextLine();
            if(input.substring(0, 1).equals("1"))
                q.add(input.substring(2));
            else if(input.substring(0, 1).equals("2"))
                q.remove();
            else
                System.out.println(q.isEmpty() ? "Empty!" : q.element()); 
        } 
    }
}
