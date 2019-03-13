public class RentedApp extends Service{
    public int currentYear;
    public int releaseYear;

    public double calculatePrice(){
        if(currentYear-releaseYear == 0)
            return super.basePrice/100;
        else if(currentYear-releaseYear <= 3)
            return 0.9 * (super.basePrice/100);
        else
            return 0.8 * (super.basePrice/100);
    }
}