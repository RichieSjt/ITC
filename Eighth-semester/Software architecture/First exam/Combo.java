import java.util.List;
import java.util.ArrayList;

public class Combo {
    private List<Product> products = new ArrayList<>();
    private boolean isCombo = true;

    public void addProduct(Product product){
        products.add(product);
    }

    public double calculateTotal(){
        double total = 0;
        for (Product p: products) {
            total += p.getPrice(isCombo);
        }
        return total;
    }

    public void showProducts(){
        for (Product p: products) {
            System.out.println("Product: " + p.getName() + ", Price: " + p.getPrice(isCombo));
        }
    }
}
