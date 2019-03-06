public class array {
    public static void main(String[] args){
    int[] numbers;
    int aofn, i, position;
    
    System.out.print("Amount of numbers to read: ");
    aofn = Integer.parseInt(System.console().readLine());

    numbers = new int [aofn];

    for(i = 0 ; i < aofn  ; i++){
        
        System.out.print("Number " + (i+1) + ": ");
        numbers[i] = Integer.parseInt(System.console().readLine());
    }

    System.out.print("Enter position: ");
    position = Integer.parseInt(System.console().readLine());
    System.out.print("The number is: " + numbers[position] );
    
    }
}