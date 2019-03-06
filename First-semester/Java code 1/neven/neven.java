public class neven {
    public static void main (String[]args){
        int n1, i;  

        System.out.print("Number 1: ");
        n1= Integer.parseInt(System.console().readLine());

        for(i=2; i <= (n1/2); i++){
           
            System.out.println(i*2);

        }
    }
}