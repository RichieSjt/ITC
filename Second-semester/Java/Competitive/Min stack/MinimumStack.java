import java.util.Scanner;
import java.util.Stack;

public class MinimumStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, queries, value = 0, top, minEle = 0;
        String input, instruction;
        String[] in;
        Stack<String> stack = new Stack<>();

        queries = Integer.parseInt(sc.nextLine());

        for(i = 0; i < queries; i++){
            input = sc.nextLine();
            in = input.split(" ");

            instruction = in[0];
            if(in.length == 2)
                value = Integer.parseInt(in[1]);

            if(instruction.equals("PUSH")){
                if(stack.empty()){
                    stack.push(value + "");
                    minEle = value;
                }else{
                    if(value >= minEle)
                        stack.push(value + "");
                    else
                        stack.push((2*value-minEle) + "");
                        minEle = value;
                }
            }else if(instruction.equals("POP")){
                top = Integer.parseInt(stack.peek());
                if(top < minEle)
                    minEle = 2*minEle-top;
                stack.pop();
            }else
                System.out.println(minEle);
        }
    }
}