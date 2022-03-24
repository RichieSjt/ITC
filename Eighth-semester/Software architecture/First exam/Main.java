class Main {
    public static void main(String[] args) {
        System.out.println("---------Combos---------\n");
        ComboBuilder comboBuilder = new ComboBuilder();        
        
        Combo combo1 = comboBuilder.combo1();
        combo1.showProducts();
        System.out.println("Combo 1 total: " + combo1.calculateTotal() + '\n');
        
        Combo combo2 = comboBuilder.combo2();
        combo2.showProducts();
        System.out.println("Combo 2 total: " + combo2.calculateTotal() + '\n');
        
        Combo combo3 = comboBuilder.combo3();
        combo3.showProducts();
        System.out.println("Combo 3 total: " + combo3.calculateTotal() + '\n');
        
        Combo combo4 = comboBuilder.combo4();
        combo4.showProducts();
        System.out.println("Combo 4 total: " + combo4.calculateTotal() + '\n');
        
        Combo combo5 = comboBuilder.combo5();
        combo5.showProducts();
        System.out.println("Combo 5 total: " + combo5.calculateTotal() + '\n');
        
        Combo combo6 = comboBuilder.combo6();
        combo6.showProducts();
        System.out.println("Combo 6 total: " + combo6.calculateTotal() + '\n');
        
        System.out.println("---------Individual---------\n");
        ProductFactory productFactory = new ProductFactory();

        Product hamburguer = productFactory.createProduct("Hamburguer", "regular");
        System.out.println("Hamburguer price: " + hamburguer.getPrice(false));
        
        Product nuggets = productFactory.createProduct("Nuggets", "regular");
        System.out.println("Nuggets price: " + nuggets.getPrice(false));
        
        Product smallSoda = productFactory.createProduct("Soda", "small");
        System.out.println("Small soda price: " + smallSoda.getPrice(false));
        
        Product mediumSoda = productFactory.createProduct("Soda", "medium");
        System.out.println("Medium soda price: " + mediumSoda.getPrice(false));
        
        Product largeSoda = productFactory.createProduct("Soda", "large");
        System.out.println("Large soda price: " + largeSoda.getPrice(false));

        Product smallFries = productFactory.createProduct("Fries", "small");
        System.out.println("Small fries price: " + smallFries.getPrice(false));

        Product mediumFries = productFactory.createProduct("Fries", "medium");
        System.out.println("Medium fries price: " + mediumFries.getPrice(false));

        Product largeFries = productFactory.createProduct("Fries", "large");
        System.out.println("Large fries price: " + largeFries.getPrice(false));
        
    }
}