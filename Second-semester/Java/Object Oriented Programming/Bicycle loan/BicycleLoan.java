public class BicycleLoan{
    public static void main(String[] args) {
        Person p1 = new Person();
        Person p2 = new Person();

        p1.RegisterPerson();
        p2.RegisterPerson();

        Bicycle b1 = new Bicycle();

        b1.RegisterBicycle();

        //Loan l1 = new Loan();

        System.out.println('\n' + "----User 1 info----" );
        p1.AccessData();

        System.out.println('\n' + "----User 2 info----" );
        p2.AccessData();

    }
}