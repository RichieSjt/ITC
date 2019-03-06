public class longsmall {
    public static void main (String[] args){

    int n, i, max, min;
    max = Integer.MAX_VALUE;
    min = Integer.MIN_VALUE;

    max = 0;
   
        
    for ( i=1 ; (i<=10) ; i++ ){
        
        System.out.print("Number " + i + ": ");
        n = Integer.parseInt(System.console().readLine());

        if(n > max){
            max = n;

        }else if (n < min){
            min = n;

            }
        }

        System.out.println("The largest number is: " + max);
        System.out.println("The smallest number is: " + min);

    }
}

