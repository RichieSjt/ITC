public class Integers {
    public static void main(String[] args){
        double product = 1, n, sum = 0, avg = 0; 
        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        
        System.out.println("---Introduce five numbers---");

        for(int i = 1; i < 6 ; i++){

            System.out.print("Number " + i +": ");
            n = Double.parseDouble(System.console().readLine());
            sum += n;
            product *=n;
            if (n > max){
                max = n;
            }
            if (n < min){
                min = n;    
            }
        }

        avg = sum/5;
        System.out.println(" ");
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + avg);
        System.out.println("Product: " + product);
        System.out.println("Maximum: " + max);
        System.out.println("Minimum: " + min);

    }
}