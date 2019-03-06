public class Bicycle{
    public int serialNumber;
    public String brand;
    public String registrationYear;

    public void RegisterBicycle(){
        System.out.print("Serial number: ");
        serialNumber = Integer.parseInt(System.console().readLine());

        System.out.print("Brand: ");
        brand = System.console().readLine();

        System.out.print("Registration Year: ");
        registrationYear = System.console().readLine();
    }
}