public class evoddval {
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

    System.out.println("Even numbers: ");
    for(i = 0 ; i <= (aofn-1) ; i++){
        if ((numbers[i] % 2 == 0)){
            
            System.out.println(numbers[i]);

        }
    }
    System.out.println("Odd numbers: ");
    for(i = 0 ; i <= (aofn-1) ; i++){
        if((numbers[i] % 2 != 0)){
            System.out.println(numbers[i]);

        }
    }

    }
}