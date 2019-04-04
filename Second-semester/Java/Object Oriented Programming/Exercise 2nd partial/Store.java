public class Store {
    public Garment[] garments;
    private int counter;

    public Store(){
        garments = new Garment[10];
    }
    public void setWear(Wear w){
        garments[counter] =  w;
        counter++;
    }
    public void setShoe(Shoe s){
        garments[counter] =  s;
        counter++;
    }
    public int numberOfGarments(){
        return counter;
    }
}