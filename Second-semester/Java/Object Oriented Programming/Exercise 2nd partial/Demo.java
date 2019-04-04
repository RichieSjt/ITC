public class Demo {
    public static void main(String[] args) {
        String barCode;

        Store s1 = new Store();
        
        Wear w1 = new Wear();
        w1.setData("Cotton", "Calvin klein", "Red", "Medium", "750");
        s1.setWear(w1);
        barCode = w1.getBarCode();
        System.out.print(barCode);
        System.out.println("Number of garments: " + s1.numberOfGarments());

    }
}