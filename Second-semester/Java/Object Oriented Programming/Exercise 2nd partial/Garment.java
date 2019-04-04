public abstract class Garment{
    protected String brand;
    protected String color;
    protected String size;
    protected String countryPrefix;

    abstract String getBarCode();
    abstract void setData();
}