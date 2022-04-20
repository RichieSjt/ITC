public class Laptop extends Product {
    public Laptop(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice() {
        return getPrice();
    }
}
