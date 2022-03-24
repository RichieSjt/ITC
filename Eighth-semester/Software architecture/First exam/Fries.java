public class Fries implements ProductSize {
    double price;

    @Override
    public String getName() {
        return "Fries";
    }
    
    @Override
    public double getPrice(boolean isCombo) {
        if(isCombo)
            return price * 0.8;
        return price;
    }

    @Override
    public void setPrice(String size) {
        if(size.equalsIgnoreCase("small"))
            price = 15;
        if(size.equalsIgnoreCase("medium"))
            price = 17;
        if(size.equalsIgnoreCase("large"))
            price = 19;
    }
}
