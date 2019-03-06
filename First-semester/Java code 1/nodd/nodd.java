public class nodd {
    public static void main (String[]args){
        int n1, i;  

        System.out.print("Number 1: ");
        n1= Integer.parseInt(System.console().readLine());

        for(i=1; i <= n1 ; i+=2){
           
            System.out.println(i);

        }
    }
}