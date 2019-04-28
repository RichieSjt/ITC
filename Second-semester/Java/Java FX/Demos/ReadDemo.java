import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadDemo {
    public static void main(String[] args) throws FileNotFoundException{

            Scanner sc = new Scanner(new File("MyFileManagementTest.java"));
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
    
    }
}