public class DessertDish extends Dish{
    public boolean lactoseFree;
    public boolean glutenFree;
    public String category;

    public int Calories(){
        boolean quality;
        int calories;
        quality = lactoseFree == true;
        quality &= glutenFree == true;
        if(quality == true){
            calories = 50;
        }else{
            calories = 150; 
        }
        return calories; 
    }

    public DessertDish(String category, boolean lactoseFree, boolean glutenFree){
        this.category = category;
        this.lactoseFree = lactoseFree;
        this.glutenFree = glutenFree;
    }

    public String requestInfo(){
        return super.requestInfo() + "\nDessert calories: " + Calories();
    }
}