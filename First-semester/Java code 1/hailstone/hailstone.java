public class hailstone {

    public static void main (String[] args){

    int n;

    System.out.print("Hailstone sequence, enter a number: ");
    n = Integer.parseInt(System.console().readLine());

        while(n!=1){

            if(n%2==0){
            n= n/2;
            System.out.println(n);

            }else{
            n= n*3 +1;
            System.out.println(n);
            }

        }

    }
}