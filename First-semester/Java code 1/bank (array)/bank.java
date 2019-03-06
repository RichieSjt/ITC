public class bank {
	public static void main (String[] args) {
		int amount;
		
		String units[] = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen","Seventeen", "Eighteen", "Nineteen"};
		String tens[] = {"", "", "Twenty", "Thirty", "Fourty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

		System.out.println("Press -1 to exit");
		System.out.print("");
		System.out.print("Enter an amount: $");
		amount= Integer.parseInt(System.console().readLine());

	while(amount != -1){
		if (amount >= 0 & amount <=999 ){
		
		if (amount==0){
		System.out.print("Zero");
		}
		
		if (amount > 19) {
                System.out.println((units[amount / 100] + ((amount/100 >= 1) ? " Hundred": "")) + " " + tens[(amount / 10)%10] + " " + units[amount % 10] + " dollars");
	
            	} else {
                System.out.println(units[amount] + " dollars");
	    	}

		System.out.print("Enter an amount: $");
		amount= Integer.parseInt(System.console().readLine());
		
		}else{
		System.out.println("Not in range");
		System.out.print("Enter an amount: $");
		amount= Integer.parseInt(System.console().readLine());
		}
   	    
	     }
	  
	}

}
