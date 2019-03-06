public class AppDemo{
    public static void main(String[] args) {
        
        Client c1 = new Client();
        c1.name = "Richie";
        c1.email = "richie@hotmail.com";
        c1.dishesRequested = 2;

        c1.clientInfo();
        c1.requestDish();
        c1.printInfo(); 
        
    }
}