import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static String output = "";

	public static void main(String[] args) {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int cases;

		try {
			cases = Integer.parseInt(br.readLine().trim());

			int i, r1, r2;
			String bIn, b1, b2;

			for (i = 0; i < cases; i++) {
				bIn = br.readLine();
	
				b1 = bIn.substring(0, bIn.indexOf(" "));
				b2 = bIn.substring(bIn.indexOf(" ") + 1); 

				r1 = Integer.parseInt(b1, 2);
				r2 = Integer.parseInt(b2, 2);

				String result = Integer.toBinaryString(r1 + r2); 

				output = (i + 1) + " " + result; 
				System.out.println(output);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}