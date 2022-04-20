public abstract class Product implements Box {
    String name;
    double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    double getPrice() {
        return price;
    }
}
