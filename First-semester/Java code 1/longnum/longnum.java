public class longnum {
    
    public static void main (String[] args){

    int n1, n2, i;
    
    System.out.print("Number 1: ");
    n1 = Integer.parseInt(System.console().readLine());
    
    for ( i=2 ; (i<=10) ; i++ ){
        
        System.out.print("Number " + i + ": ");
        n2 = Integer.parseInt(System.console().readLine());

        if (n1<=n2){
            n1=n2;
        }
    }
    
    System.out.println("The largest number is: " + n1 );

    }
}