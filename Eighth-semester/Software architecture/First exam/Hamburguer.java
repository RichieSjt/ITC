public class Hamburguer implements Product {
    double price;

    @Override
    public String getName() {
        return "Hamburguer";
    }
    
    @Override
    public double getPrice(boolean isCombo) {
        price = 40 ;

        if(isCombo)
            price = 35;
        
        return price;
    }
}