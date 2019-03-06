import java.util.Scanner;
import java.io.File;

public class CountLetters {
	public static void main(String[] args) {
		System.out.println(getCode("hello"));
	}
	
	public static int getCode(String word) {
		word = word.toLowerCase();
		int count = 0;
		for (char letter : word.toCharArray()) {
			count += letter - 'a';
		}
		
		return count;
	}
}