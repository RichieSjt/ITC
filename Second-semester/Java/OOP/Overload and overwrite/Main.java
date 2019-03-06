public class Main{
    public static void main(String[] args) {
        
        Dog d1 = new Dog();

        d1.age = 5;
        d1.name = "Apollo";
        d1.healthy = true;
        d1.breed = "German sheperd";

        //Calling overloaded method
        d1.dogCharacteristics(d1.age);
        d1.dogCharacteristics(d1.healthy);

        //Calling overwritten method
        d1.coolBreed(d1.breed);
    }
}