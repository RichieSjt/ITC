public class Wear extends Garment{
    private String fabric;
    private String controlNumber = "1234";

    public void setData(String fabric, String brand, String color, String size, String countryPrefix){
        this.fabric = fabric;
        super.brand = brand;
        super.color = color;
        super.size = size;
        super.countryPrefix = countryPrefix;
    }
    public String getBarCode(){
        String barCode;

        barCode += super.countryPrefix;
        barCode += controlNumber;
    }

}