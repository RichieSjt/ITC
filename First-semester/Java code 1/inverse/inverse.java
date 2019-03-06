9public class inverse {
    public static void main(String[] args){
    int[] numbers;
    int aofn, i;
    
    System.out.print("Amount of numbers to read: ");
    aofn = Integer.parseInt(System.console().readLine());

    numbers = new int [aofn];

    for(i = 0 ; i < aofn  ; i++){
        
        System.out.print("Number " + (i+1) + ": ");
        numbers[i] = Integer.parseInt(System.console().readLine());
    }

    System.out.println("The inverse order of the numbers given is: ");

        for(i = (aofn- 1); i >= 0  ; i-- ){
        System.out.println(numbers[i]);
        }
    }
}