public class Nuggets implements Product {
    double price;

    @Override
    public String getName() {
        return "Nuggets";
    }

    @Override
    public double getPrice(boolean isCombo) {
        price = 38;

        if(isCombo)
            price = 32;
        
        return price;
    }

}
