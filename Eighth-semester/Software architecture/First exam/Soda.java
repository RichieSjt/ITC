public class Soda implements ProductSize {
    double price;

    @Override
    public String getName() {
        return "Soda";
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
            price = 17;
        if(size.equalsIgnoreCase("medium"))
            price = 18;
        if(size.equalsIgnoreCase("large"))
            price = 20;
    }
}
