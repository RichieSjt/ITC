import java.util.Scanner;
import java.util.Stack;

public class EasyStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, queries;
        String input;
        Stack<String> stack = new Stack<>();

        queries = Integer.parseInt(sc.nextLine());

        for(i = 0; i < queries; i++){
            input = sc.nextLine();
            switch(input.substring(0, 1)){
                case "1": stack.push(input.substring(2)); break;
                case "2": stack.pop(); break;
                case "3": System.out.println(stack.empty() ? "Empty!" : stack.peek()); break;
            }
        }
    }
}