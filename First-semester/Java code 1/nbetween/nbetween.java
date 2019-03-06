public class nbetween {
    public static void main (String[] args){
        int n1, n2, low, high;

        System.out.print("Number 1: ");
        n1= Integer.parseInt(System.console().readLine());

        System.out.print("Number 2: ");
        n2= Integer.parseInt(System.console().readLine());
        
        System.out.println("Numbers in between: ");

        low = (n1 > n2) ? n2: n1;
        high = (n1 > n2) ? n1: n2;

        while (low <= high){

            System.out.println(low);
            low++;
        
        }
    }
}