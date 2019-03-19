public abstract class Person implements iRegistry{
    private String birthDate;
    protected String day, month, year;

    public String getBirthDate() {
        return birthDate;
    }

    /**
     * @param birthDate: date in the format dd/mm/yyyy
     */

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        String[] elems = birthDate.split("/");
        day = elems[0];
        month = elems[1];
        year = elems[2];
    }
}