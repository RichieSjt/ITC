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
            switch(input.substring(0, 1)){
                case "1": q.add(input.substring(2)); break;
                case "2": q.remove(); break;
                case "3": System.out.println(q.isEmpty() ? "Empty!" : q.element()); break;
            }
        } 
    }
}
