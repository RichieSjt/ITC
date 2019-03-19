public class Demo {
    public static void main(String[] args) {
        MoralPerson mp = new MoralPerson();

        mp.setBirthDate("29/11/2012");
        mp.setCompanyName("Instituto Tecnologico Estudios Superiores Monterrey");
        String rfc = mp.calculateRFC();

        System.out.println(rfc);
    }
}