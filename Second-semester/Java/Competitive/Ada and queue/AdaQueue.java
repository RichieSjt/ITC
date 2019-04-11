import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class AdaQueue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i, queries;
        String input;
        String[] in;
        Deque<String> q = new LinkedList<>();

        queries = Integer.parseInt(sc.nextLine());

        for(i = 0; i < queries; i++){
            input = sc.nextLine();
            in = input.split(" ");
            if(in.length == 2){
                switch(in[0]){
                    case "toFront": q.addFirst(in[1]); break;
                    case "push_back": q.addLast(in[1]); break;
                }
            }else{
                switch(in[0]){
                    case "front": System.out.println(q.pollFirst()); break;
                    case "back": System.out.println(q.pollLast()); break;
                    case "reverse": q = reverseQueue(q); break;
                }   
            }
        }
    }

    public static Deque<String> reverseQueue(Deque<String> q){
        Deque<String> rq = new LinkedList<>();
        while(!q.isEmpty()){
            rq.add(q.getLast() + "");
            q.poll();
        }
        return rq;
    }

}