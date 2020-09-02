import java.util.Scanner;
import java.util.Stack;

public class StreetParade {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, cars, counter = 1;
        String input;
        String[] numbers;
        int[] numbersInt;
        Stack<Integer> stack = new Stack<>();
  
        cars = Integer.parseInt(sc.nextLine());
        input = sc.nextLine();
        numbers = input.split(" ");

        numbersInt = new int[numbers.length];
        for(i = 0; i <numbers.length; i++){
            numbersInt[i] = Integer.parseInt(numbers[i]); 
        }
        for(i = 0; counter+1 <= numbersInt.length; i++){
            if(!stack.empty() && stack.peek() == counter){
                stack.pop();
                counter++;
                i--;
                System.out.println("numero: " + numbersInt[i]);
                System.out.println("counter: " + counter);
            }
            else{
                if(numbersInt[i] == counter){
                    counter++;
                    System.out.println("numero: " + numbersInt[i]);
                    System.out.println("counter: " + counter);
                }else{
                    stack.push(numbersInt[i]);
                    System.out.println("numero: " + numbersInt[i]);
                    System.out.println("counter: " + counter);
                }
            } 
        }
        System.out.println(counter == cars ? "yes" : "no");
    }
}