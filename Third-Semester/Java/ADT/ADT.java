import java.util.Scanner;

public class ADT {
    public static void main(String[] args) {
        String selectedCalculation;
        String selectedOption; 
        Shape shape;

        System.out.println("In code we trust");
        Scanner sc = new Scanner(System.in);

        System.out.println("Elige la figura: 1)Cuadrado");
        selectedOption = sc.nextLine();

        switch(selectedOption){
            case "1": System.out.println("Dame el lado del cuadrado: ");
            break;
        }

        System.out.println("Que desesas calcular? 1)Area");
        selectedCalculation = sc.nextLine();

        switch(selectedCalculation){
            case "1": ;break;

        }
        sc.close();
    }
}