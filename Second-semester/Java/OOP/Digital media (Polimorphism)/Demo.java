import java.util.GregorianCalendar;

public class Demo{
    public static void main(String[] args) {

        Videogame Fortnite = new Videogame();
        Fortnite.title = "Fortnite";
        Fortnite.genre = "Shooter";
        Fortnite.classification = "E";
        Fortnite.language = "English";

        Fortnite.publisher = "Epic games";
        Fortnite.platform = "All";
        Fortnite.region = "North America";
        Fortnite.releaseDate = new GregorianCalendar(2018, 2, 22).getGregorianChange();

        System.out.println(Fortnite);

        DigitalMedia d = new Videogame(); //Reference class DigitalMedia, creation class Videogame() 
        d.genre = "Genre"; //The attributes that you can access are defined by DigitalMedia
        System.out.println(d); //The object behaves as a Videogame

        Movie m = new Movie();
        m.title = "Seven";
        m.director = "David Fincher";
        m.duration = 120;
        m.oscarNominations = 0;      
        m.genre = "Thriller";
        m.classification = "18+";
        
        //Implicit convertion, a videogame stored in digital media, a movie in digital media
        DigitalMedia[] dm = new DigitalMedia[10];
        dm[0] = Fortnite;  //The attributes are defined by DigitalMedia, so you can´t access
        dm[1] = m;         //Videogames or Movies methods

        System.out.println(dm[0]);
        System.out.println(dm[1]);

        //Explicit convertion, a digital media created as a videogame
        Videogame v2 = (Videogame)dm[0];
        
        //This is called Polimorphism, an object can acquire different forms
    }
}