public class RegularDish extends Dish{
    public String category;

    public String Weight(){
        String weight = "";
        
        switch(category){
            case "chicken": weight = "220"; break;
            case "soup": weight = "100"; break;
            case "meat": weight = "300"; break;
            case "other": weight = "50"; break;
        }
        return weight;
    }

    public RegularDish(String category){
        this.category = category;
    }
    public String requestInfo(){
        return super.requestInfo() + "\nRegular dish weight: " + Weight();
    }

}