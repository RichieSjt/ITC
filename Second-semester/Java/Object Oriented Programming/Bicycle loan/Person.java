public class Person{
    public int age;
    public String name; 
    public String surname;
    public String registrationDate;
    public String bankAccount;
    public String bankName;

    public void RegisterPerson(){
        System.out.print("Name: ");
        name = System.console().readLine();

        System.out.print("Surname: ");
        surname = System.console().readLine();

        System.out.print("Age: ");
        age = Integer.parseInt(System.console().readLine());

        System.out.print("Registration date: ");
        registrationDate = System.console().readLine();

        System.out.print("Bank account number: ");
        bankAccount = System.console().readLine();

        System.out.print("Bank name: ");
        bankName = System.console().readLine();    
    }

    public void AccessData(){
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Surname: " + surname);
        System.out.println("Registration date: " + registrationDate);
        System.out.println("Bank account: " + bankAccount);
        System.out.println("Bank name: " + bankName);
    }
}