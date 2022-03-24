public class ProductFactory {
    public Product createProduct(String type, String size) {
        if(type.equalsIgnoreCase("Hamburguer")){
            return new Hamburguer();
        }
        if(type.equalsIgnoreCase("Nuggets")){
            return new Nuggets();
        }
        if(type.equalsIgnoreCase("Soda")){
            Soda soda = new Soda();
            soda.setPrice(size);
            return soda;
        }
        if(type.equalsIgnoreCase("Fries")){
            Fries fries = new Fries();
            fries.setPrice(size);
            return fries;
        }
        
        return null;
    }
}
