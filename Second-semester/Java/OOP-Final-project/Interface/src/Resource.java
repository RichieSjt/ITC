import java.io.Serializable;

 abstract class Resource implements Serializable{
    protected String language;
    protected String region;
    protected String responsible;
    protected String status;
    protected String textualContent;
    protected String resourceType; 
    
    public String toString(){
        return "Language: " + language;
    }

    public void setLanguage(String language) throws EmptyFieldException{
        if (language == null || language.length() == 0)
            throw new EmptyFieldException ("Please enter a language");
        this.language = language;
    }
    public void setRegion(String region) throws EmptyFieldException{
        if (region == null || region.length() == 0)
            throw new EmptyFieldException ("Please enter a region");
        this.region = region;
    }
    public void setResponsible(String responsible) throws EmptyFieldException{
        if (responsible == null || responsible.length() == 0)
            throw new EmptyFieldException ("Please assign a responsible");
        this.responsible = responsible;
    }
    public void setStatus(String status) throws EmptyFieldException{
        if (status == null || status.length() == 0)
            throw new EmptyFieldException ("Please select a status");
        this.status = status;
    }
    public void setTextualContent(String textualContent) throws EmptyFieldException{
        if (textualContent == null || textualContent.length() == 0)
            throw new EmptyFieldException ("Please enter the text content");
        this.textualContent = textualContent;
    }
    public void setResourceType(String resourceType) throws EmptyFieldException{
        if (resourceType == null || resourceType.length() == 0)
            throw new EmptyFieldException ("Please enter the text content");
        this.resourceType = resourceType;
    }
    public String getLanguage(){
        return language;
    }
    public String getRegion(){
        return region;
    }
    public String getResponsible(){
        return responsible;
    }
    public String getStatus(){
        return status;
    }
    public String getTextualContent(){
        return textualContent;
    }
    public String getResourceType(){
        return resourceType;
    }
}


