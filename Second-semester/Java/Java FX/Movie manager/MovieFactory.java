import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class MovieFactory {
    public static void main(String[] args) {
        try {
            Movie m = new Movie();
            m.setTitle("Avengers endgame");
            m.setDirector("Russo Brothers");
            m.setYear("2019");
            m.setDuration("3:01");
            m.setClassification("G");

            FileOutputStream fos = new FileOutputStream("movies.oop");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(m);
            oos.close();

        }catch(EmptyFieldException e){
            System.out.println(e.getMessage());
        }catch(FileNotFoundException fe){
            System.out.println("File not found");
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }
}