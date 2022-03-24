public class ComboBuilder {
    ProductFactory productFactory = new ProductFactory();

    Product hamburguer = productFactory.createProduct("Hamburguer", "regular");
    Product nuggets = productFactory.createProduct("Nuggets", "regular");
    Product smallSoda = productFactory.createProduct("Soda", "small");
    Product mediumSoda = productFactory.createProduct("Soda", "medium");
    Product largeSoda = productFactory.createProduct("Soda", "large");
    Product smallFries = productFactory.createProduct("Fries", "small");
    Product mediumFries = productFactory.createProduct("Fries", "medium");
    Product largeFries = productFactory.createProduct("Fries", "large");
    

    public Combo combo1() {
        Combo combo = new Combo();
        combo.addProduct(hamburguer);
        combo.addProduct(largeSoda);
        combo.addProduct(largeFries);
        return combo;
    }

    public Combo combo2() {
        Combo combo = new Combo();
        combo.addProduct(hamburguer);
        combo.addProduct(smallSoda);
        combo.addProduct(smallFries);
        return combo;
    }

    public Combo combo3() {
        Combo combo = new Combo();
        combo.addProduct(hamburguer);
        combo.addProduct(mediumSoda);
        combo.addProduct(mediumFries);
        return combo;
    }

    public Combo combo4() {
        Combo combo = new Combo();
        combo.addProduct(nuggets);
        combo.addProduct(largeSoda);
        combo.addProduct(largeFries);
        return combo;
    }

    public Combo combo5() {
        Combo combo = new Combo();
        combo.addProduct(nuggets);
        combo.addProduct(smallSoda);
        combo.addProduct(smallFries);
        return combo;
    }
    
    public Combo combo6() {
        Combo combo = new Combo();
        combo.addProduct(nuggets);
        combo.addProduct(mediumSoda);
        combo.addProduct(mediumFries);
        return combo;
    }
}
