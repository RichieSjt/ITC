public class Movie extends DigitalMedia{
    public String director;
    public double duration;
    public int oscarNominations;

    public String toString(){
        return "I am a movie";
    }
    public boolean hasOscarNominations(){
        return oscarNominations > 0;
    }
}