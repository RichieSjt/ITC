import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CompositeBox implements Box {
    List<Box> children = new ArrayList<>();

    public CompositeBox(Box ...boxes) {
        children.addAll(Arrays.asList(boxes));
    }

    @Override
    public double calculatePrice() {
        double totalPrice = 0;
        
        for(Box box : children) {
            totalPrice += box.calculatePrice();
        }

        return totalPrice;
    }
}
