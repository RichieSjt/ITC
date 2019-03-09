public class DemoCSP {
    public static void main(String[] args) {
        CSPFactory factory = new CSPFactory();
        
        CSP att = factory.createATT(100, 10); //ATT&T Object
        double cost = att.calculateCost(); //Call the method to calculate the total cost
        System.out.println("ATT service cost: " + cost);

        CSP axtel = factory.createAxtel("satellite", 150);
        cost = axtel.calculateCost();
        System.out.println("Axtel service cost: " + cost);

        CSP infinitum = factory.createInfinitum(25, 200, 234);
        cost = infinitum.calculateCost();
        System.out.println("Infinitum service cost: " + cost);
    }
}