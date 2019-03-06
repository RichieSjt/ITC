public class nsquare {
        public static void main (String[] args){
        int n1, i;

        System.out.print("Introduce a number: ");
        n1= Integer.parseInt(System.console().readLine());

        i= 1;

        while (i <= n1){
            System.out.println(i * i);
            i++;
        }
    }     
}


