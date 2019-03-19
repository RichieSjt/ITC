public class MoralPerson extends Person {
    public String companyName;

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String calculateRFC() {
        String rfc = "";

        String[] words = companyName.split(" ");
        for(int i = 0; i < 3 && i < words.length; i++)
            rfc += words[i].charAt(0); 

        rfc += year.substring(2);
        rfc += month;
        rfc += day;

        return rfc;
    }
}