import java.util.Scanner;
import java.math.*;

public class Integration {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double result, a, b, n;

        System.out.print("Enter a: ");
        a = Double.parseDouble(sc.nextLine());
        System.out.print("Enter b: ");
        b = Double.parseDouble(sc.nextLine());
        System.out.print("Enter n: ");
        n = Double.parseDouble(sc.nextLine());

        result = trapezoid(a, b, n);
        System.out.println("\nTrapezoid: " + result);

        result = midpoint(a, b, n);
        System.out.println("Midpoint: " + result);

        result = simpson(a, b, n);
        System.out.println("Simpson: " + result);
        
    }

    public static double trapezoid(double a, double b, double n){
        double x, interval, result = 0;
        int i;

        interval = (b - a)/n;
        x = a;

        for(i = 1; i <= n+1 ; i++){
            if(i == 1 || i == n+1)
                result += (/*For example x*/x);  //Enter a function here
            else
                result += 2*(/*For example x*/x);    //Enter a function here
            x += interval; 
        }
        return (result/2)*interval;
    }

    public static double midpoint(double a, double b, double n){
        double x, interval, result = 0;
        int i;

        interval = (b - a)/n;
        x = (a + (a + interval))/2;

        for(i = 1; i <= n ; i++){
            result += (/*For example x*/x);  //Enter a function here
            x += interval;
        }
        return result*interval;
    }

    public static double simpson(double a, double b, double n){
        double x, interval, mult, result = 0;
        int i;

        interval = (b - a)/n;
        mult = (b - a)/(3*n);
        x = a;

        for(i = 1; i <= n+1 ; i++){
            if(i == 1 || i == n+1)
                result += (/*For example x*/x);  //Enter a function here
            else if(i%2 == 0)
                result += 4*(/*For example x*/x);    //Enter a function here
            else
                result += 2*(/*For example x*/x);    //Enter a function here
            x += interval; 
        }
        return result*mult;
    }
}