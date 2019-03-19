public class Demo {
    public static void main(String[] args) {
        String rfc, curp;

        MoralPerson mp = new MoralPerson();
        mp.setBirthDate("29/11/2012");
        mp.setCompanyName("Instituto Tecnologico Estudios Superiores Monterrey");
        rfc = mp.calculateRFC().toUpperCase();
        System.out.println("Moral person " + mp.getCompanyName() + " rfc: "+ rfc);

        PhysicalPerson pp = new PhysicalPerson();
        pp.setBirthDate("21/03/1981");
        pp.enterData("Carlos", "Flores", "Perez", "DF", "Male");
        rfc = pp.calculateRFC().toUpperCase();
        curp = pp.calculateCURP().toUpperCase();
        System.out.println("Physical person " + pp.getName() + " rfc: "+ rfc);
        System.out.println("Physical person " + pp.getName() + " curp: "+ curp);


    }
}