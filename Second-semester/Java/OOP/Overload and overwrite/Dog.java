public class Dog extends Animal{
    public String breed;

    //-----------Overwritten method--------------
    
    public void coolBreed(String breed){
        System.out.println("Your dog is a " + breed + ", cool!");
    }
}