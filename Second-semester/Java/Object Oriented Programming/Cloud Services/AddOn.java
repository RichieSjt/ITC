public class AddOn extends Service{
    public boolean firstTime;

    public double calculatePrice(){
        if (firstTime == true)
            return 20 * (super.basePrice/100);
        else
            return 10 * (super.basePrice/100);
    }
}