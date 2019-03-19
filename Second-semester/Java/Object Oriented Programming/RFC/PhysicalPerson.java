public class PhysicalPerson extends Person implements iKey{
    private String name;
    private String paternalLastName;
    private String maternalLastName;
    private String cityCode;
    private String gender;
    private String rfc;

    public void enterData(String name, String paternalLastName, String maternalLastName, String cityCode, String gender){
        this.name = name;
        this.paternalLastName = paternalLastName;
        this.maternalLastName = maternalLastName;
        this.cityCode = cityCode;
        this.gender = gender;
    }
    public String getName(){
        String fullName = "";
        fullName += name + " ";
        fullName += paternalLastName + " ";
        fullName += maternalLastName;
        return fullName;
    }

    public String calculateRFC(){
        String rfc = "";
        rfc += paternalLastName.substring(0, 2);
        rfc += maternalLastName.charAt(0);
        rfc += name.charAt(0);
        rfc += year.substring(2);
        rfc += month;
        rfc += day;

        this.rfc = rfc;
        return rfc;
    }

    public String calculateCURP(){
        String curp = "";
        int checkValue = (int)(Math.random()*99);

        curp += rfc;
        if(gender.equals("Male"))
            curp += "H";
        else
            curp += "M";
        curp += cityCode;
        curp += consonant(paternalLastName);
        curp += consonant(maternalLastName);
        curp += consonant(name);
        curp += checkValue;

        return curp; 
    }

    private String consonant(String input){
        String word, consonant = "";
        int i, counter = 0;
        word = input.toUpperCase();

        for(i = 1; i < word.length(); i++){
            if(word.charAt(i) != 'A' && word.charAt(i) != 'E' && word.charAt(i) != 'I' && word.charAt(i) != 'O' && word.charAt(i) != 'U'){
                counter++;
            }
            if(counter == 1){
                consonant = word.charAt(i) + "";
                break;
            }
        }
        return consonant;
    }
}