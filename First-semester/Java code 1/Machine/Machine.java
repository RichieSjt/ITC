public class Machine {
	public static void main (String[] args) {
		int selection, money, answer, c1, c2, c5, c10, n;
		int t=0;
	
		System.out.println("#  Product        price");
		System.out.println("1. chips         = $8");
		System.out.println("2. chocolate     = $12");
		System.out.println("3. soda          = $9");
		System.out.println("4. candies       = $6");
		System.out.println("5. chewing gum   = $4");

		System.out.println("Select a number of product");
		selection= Integer.parseInt(System.console().readLine());
		
		System.out.println("How many do you want?");
		n = Integer.parseInt(System.console().readLine());

		switch(selection) {
		case 1: t=(8*n); break;
		case 2: t=(12*n); break;
		case 3: t=(9*n); break;
		case 4: t=(6*n); break;
		case 5: t=(4*n); break;
		}

		System.out.println("Insert the number of coins");

		System.out.println("$1: ");
		c1= Integer.parseInt(System.console().readLine());

		System.out.println("$2: ");
		c2= Integer.parseInt(System.console().readLine());
		
		System.out.println("$5: ");
		c5= Integer.parseInt(System.console().readLine());

		System.out.println("$10: ");
		c10= Integer.parseInt(System.console().readLine());

		money = ((c1+(2*c2)+(5*c5)+(10*c10))-t);
		
		if (money >= 0){
		System.out.println("Change: " + (money));
		}else{
		System.out.println("Not enough money");
		}

	}
}
		

		
