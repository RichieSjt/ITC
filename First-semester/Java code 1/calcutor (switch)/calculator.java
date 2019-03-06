public class calculator {
    
    public static void main (String[] args){
    char operator;
    double n1, n2, r = 0;

    System.out.println("Enter = to finish operations");

    System.out.println("Enter an operation ");
    System.out.print("Number: "); 
    n1 = Double.parseDouble(System.console().readLine());
    System.out.print("Operator: "); 
    operator = System.console().readLine().charAt(0);
    System.out.print("Number: "); 
    n2 = Double.parseDouble(System.console().readLine());
    
    switch(operator) {
        case '+': r = (n1 + n2) ; break;
        case '-': r = (n1 - n2); break;
        case '/': r = (n1 / n2); break;
        case '*': r = (n1 * n2); break;
        default: System.out.println("Illigal Operation");
        }
        n1=r;
        System.out.println("Result: " + r);
        
        System.out.print("Operator: ");
        operator = System.console().readLine().charAt(0);

        while (operator != '='){

            System.out.print("Number: "); 
            n2 = Double.parseDouble(System.console().readLine());
            
            switch(operator) {
                case '+': r = (n1 + n2) ; break;
                case '-': r = (n1 - n2); break;
                case '/': r = (n1 / n2); break;
                case '*': r = (n1 * n2); break;
                default: System.out.println("Illigal Operation");
                }
                
                System.out.println("Result: " + r);

                n1=r;
                System.out.print("Operator: ");
                operator = System.console().readLine().charAt(0);
            
        }
        System.out.println("Final result: " + r);
    }
}