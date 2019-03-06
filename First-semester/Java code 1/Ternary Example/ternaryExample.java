public class ternaryExample{
    public static void main(String[] args){
        int min, a=3, b=2;

        //Si "a" es menor a "b" resulta true, entonces al valor de min se le asigna "a",
        //de otro modo se le asigna "b"
        
        min = a < b ? a : b;
        System.out.println("Minimum value: " + min);

    }
}
    
    