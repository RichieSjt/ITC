import java.util.Scanner;
import java.io.File;

public class Caesar {
	public static void main(String[] args) throws Exception {
		String filename = "mistery.txt";
		Scanner sc = new Scanner(new File(filename));
		String content = "";
		while (sc.hasNext()) {
			content += sc.nextLine() + "\n";
		}
		//PUT YOUR CODE HERE
		System.out.println(content);
	}
	
	/**
	 * Function to apply a shift to a letter in the alphabet
	 * @param letter: The letter to use
	 * @param offset: The shift to apply. This must be a positive number
	 */
	public static char convert(char letter, int offset) {
		if (offset < 0) {
			System.out.println("The offset must be positive");
			return letter;
		}
		else if (letter >= 'a' && letter <= 'z') {
			int size = 'z'-'a'+1;
			int pos = letter - 'a';
			pos = (pos + offset) % size;
			return (char)(pos + 'a');
		}
		
        return letter;
	}
}