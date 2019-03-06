public class Test {
	public static void main (String[] args) {
		boolean q1, q2, q3, q4, q5;
		int soulmate, a1, a2, a3, a4, a5;
		
		System.out.println("Soulmate test");
		System.out.println("");


		System.out.print("Do you like dogs? ");
		q1 = Boolean.parseBoolean(System.console().readLine());
		if (q1==true){
		a1= 20;
		}else{
		a1= 0;
		}

		System.out.print("Do you like movies? ");
		q2 = Boolean.parseBoolean(System.console().readLine());
		if (q2==true){
		a2= 20;
		}else{
		a2= 0;
		}

		System.out.print("Are you less than 30 years? ");
		q3 = Boolean.parseBoolean(System.console().readLine());
		if (q3==true){
		a3= 20;
		}else{
		a3= 0;
		}

		System.out.print("Are you nice? ");
		q4 = Boolean.parseBoolean(System.console().readLine());
		if (q4==true){
		a4= 20;
		}else{
		a4= 0;
		}

		System.out.print("Do you like to travel? ");
		q5 = Boolean.parseBoolean(System.console().readLine());
		if (q5==true){
		a5= 20;
		}else{
		a5= 0;
		}
		
		soulmate = (a1+a2+a3+a4+a5);
		System.out.println("You are %" + soulmate + " compatible with me");
		

	}
}