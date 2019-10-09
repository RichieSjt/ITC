import java.util.Scanner;
import java.util.Arrays;

	public class B{
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);

			int n = Integer.parseInt(sc.nextLine());
			int first = Integer.parseInt(sc.nextLine());
	
			int[] votes = new int[n-1];
	
			for(int i = 0; i < n-1; i++){
				votes[i] = Integer.parseInt(sc.nextLine());
	
			}
			Arrays.sort(votes);
	
			if(first > votes[n-2] || (first == votes[0] && first == votes[n-2]))
				System.out.println("S");
			else
				System.out.println("N");

		}
	}
