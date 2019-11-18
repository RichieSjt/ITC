public class Recording extends Resource {
    private String duration;
    private String path;

    public String toString(){
        return "Language: " + language + " , (" + duration + ") "+ status; 
    }

    public void setDuration(String duration) throws EmptyFieldException{
        if (duration == null || duration.length() == 0)
            throw new EmptyFieldException ("Please enter the duration");
        this.duration = duration;
    }
    public void setPath(String path) throws EmptyFieldException{
        if (path == null || path.length() == 0)
            throw new EmptyFieldException ("Please enter the file path");
        this.path = path;
    }
    public String getDuration(){
        return duration;
    }
    public String getPath(){
        return path;
    }
}