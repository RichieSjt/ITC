public class DemoCSP {
    public static void main(String[] args) {
        CSPFactory factory = new CSPFactory();
        //Client data
        double usedMb = 100;
        int channels = 10;
        //ATT&T Object
        CSP att = factory.createATT(usedMb, channels);
        //Call the method to calculate the total cost
        double cost = att.calculateCost();
        System.out.println(cost);
    }
}