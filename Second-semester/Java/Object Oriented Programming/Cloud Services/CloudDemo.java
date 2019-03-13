public class CloudDemo{
    public static void main(String[] args) {
        double price;

        CloudService c1 = new CloudService();

        Service addOn = c1.requestAddOn(true);
        price = addOn.calculatePrice();
        System.out.println("Total add-on sell price: $" + price + " dollars");

        Service rentedApp = c1.requestRentedApp(2017);
        price = rentedApp.calculatePrice();
        System.out.println("Total app rent price: $" + price + " dollars");

        Service hostedApp = c1.requestHostedApp(135, 1250);
        price = hostedApp.calculatePrice();
        System.out.println("Total host rent price: $" + price + " dollars");
    }
}