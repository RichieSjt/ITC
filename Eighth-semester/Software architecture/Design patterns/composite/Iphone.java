public class Iphone extends Product {
    public Iphone(String name, double price) {
        super(name, price);
    }

    @Override
    public double calculatePrice() {
        return getPrice();
    }
}