import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MovieReader {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("movies.oop");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Movie v = (Movie)ois.readObject();
            System.out.println("Title: " + v.getTitle() + ", Director: " + v.getDirector() + ", Duration: " + v.getDuration());

            ois.close();
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (ClassNotFoundException cnfe){
            System.out.println(cnfe.getMessage());
        }
    }
}