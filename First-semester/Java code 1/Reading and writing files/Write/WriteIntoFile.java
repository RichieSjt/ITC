import java.io.*;

public class WriteIntoFile {
	public static void main(String[] args) throws Exception {
		FileWriter fw = new FileWriter(new File("test2.txt"));
		String[] words = {"This", "Is", "Just", "A", "Test"};
		
		for (String word : words) {
			fw.write(word + "\r\n");
		}
		fw.close();
	}
}
