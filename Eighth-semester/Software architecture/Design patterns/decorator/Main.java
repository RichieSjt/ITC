public class Main {
    public static void main(String[] args) {
        Product soda = new Soda();
        Product smallSoda = new ProductSizeDecorator(soda, "small");

        System.out.println("Product: " + smallSoda.getName());
    }
}
