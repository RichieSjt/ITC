public class Main {
    public static void main(String[] args) {
        Product iphone8 = new Iphone("Iphone 8", 799.99);
        Product iphone11 = new Iphone("Iphone 11", 1200.99);
    
        Box phonesBox = new CompositeBox(iphone8, iphone11);
    
        Product asuslaptop = new Laptop("Asus laptopt", 1659.99);
        Product acerlaptop = new Laptop("Acer laptopt", 1300);
    
        Box laptopsBox = new CompositeBox(asuslaptop, acerlaptop);
        
        Box mainBox = new CompositeBox(phonesBox, laptopsBox);
        
        System.out.println("Total price: " + mainBox.calculatePrice());
    }
}
