public class PhysicalPerson extends Person implements iKey{
    private String name;
    private String paternalLastName;
    private String maternalLastName;
    private String cityCode;
    private String gender;

    public String calculateRFC(){
        String rfc = "";
        rfc += paternalLastName.substring(0, 2);
        rfc += maternalLastName.charAt(0);
        rfc += name.charAt(0);
        rfc += year.substring(2);
        rfc += month;
        rfc += day;

        return rfc;
    }

    public String calculateCURP(){
        String curp = "";
        return curp; 
    }
}