public class Calculation{
    public int n1;
    public int n2;
    public int sum;
    public int div;

    public void AskNumbers(){
        System.out.print("Number 1: ");
        n1 = Integer.parseInt(System.console().readLine());

        System.out.print("Number 2: ");
        n2 = Integer.parseInt(System.console().readLine());
    }

    public void Sum(){
        sum = n1 + n2;
    }
    public void Div(){
        div = n1/n2;
    }
    public void Result(){
        System.out.println("Sum: " + sum);
        System.out.println("Div: " + div);
    }

}