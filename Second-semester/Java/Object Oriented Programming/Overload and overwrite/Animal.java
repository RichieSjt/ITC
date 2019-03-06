public class Animal {
    public int age;
    public String name;
    public boolean healthy;

    //-----------Method to be overwritten--------------

    public void coolBreed() {
        System.out.println("Your dog is cool!");
    }

    //--------------Overloaded method-----------------

    public void dogCharacteristics(int age) {
        if (age < 9)
            System.out.println("Your dog is young");
        else
            System.out.println("Your dog is old");
    }

    public void dogCharacteristics(boolean healthy) {
        if (healthy == true)
            System.out.println("Your dog is healthy");
        else
            System.out.println("Your dog needs a checkup");
    }
}