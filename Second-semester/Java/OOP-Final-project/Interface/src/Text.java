public class Text extends Resource {
    private String numberOfPages;
    private String numberOfWords;

    public String toString(){
        return "Language: " + language + " , (" + numberOfWords + " words) " + "Status: " + status; 
    }

    public void setNumberOfPages(String numberOfPages) throws EmptyFieldException{
        if (numberOfPages == null || numberOfPages.length() == 0)
            throw new EmptyFieldException ("Please enter the number of pages");
        this.numberOfPages = numberOfPages;
    }
    public void setNumberOfWords(String numberOfWords) throws EmptyFieldException{
        if (numberOfWords == null || numberOfWords.length() == 0)
            throw new EmptyFieldException ("Please enter the number of words");
        this.numberOfWords = numberOfWords;
    }
    public String getNumberOfPages(){
        return numberOfPages;
    }
    public String getNumberOfWords(){
        return numberOfWords;
    }
}