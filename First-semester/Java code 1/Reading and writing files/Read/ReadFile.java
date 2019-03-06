import java.util.Scanner;
import java.io.File;
public class ReadFile {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(new File("test.txt"));
		String content = "";
		String[] lines;
		
		while (sc.hasNext()) {
			content += sc.nextLine() + "\n";
		}
		
		lines = content.split("\n");
		for (String l : lines) {
			System.out.println(l);
		}
		sc.close();
	}
}

