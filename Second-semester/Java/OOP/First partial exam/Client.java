public class Client{
    public String name;
    public String email;
    public int dishesRequested;
    public Dish[] dishes;

    public void requestDish(){
        dishes = new Dish[2];
        dishes[0] = new RegularDish("chicken");
        dishes[1] = new DessertDish("strawberries", true, true);
    }
    public void printInfo(){
        System.out.println(dishes[0].requestInfo());
        System.out.println(dishes[1].requestInfo());
    }
    public void clientInfo(){
        System.out.println("Client: " + name);
        System.out.println("Email: " + email);
        System.out.println("Dishes requested: " + dishesRequested);
    }
}