public class err {
    public static void main (String[] args){
        int number; String name;

        number= Integer.parseInt(System.console().readLine());
        name = System.console().readLine();

        if (number > 0){
            System.print(name);
        }
        else{
            System.print("Goodbye");
        }
    }
}