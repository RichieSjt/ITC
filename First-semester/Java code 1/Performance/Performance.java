public class Performance {
	public static void main (String[] args) {
		double p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, pT;

		System.out.print("How long did it took you to run 100m? ");
		p1 = Double.parseDouble(System.console().readLine());
		p1 = (25.4347 * Math.pow(18-p1, 1.81));

		System.out.print("How far does the throw was? ");
		p2 = Double.parseDouble(System.console().readLine());
		p2 = (12.91 * Math.pow(p2-4, 1.1));
		
		System.out.print("How high did you jumped in the Pole vault? ");
		p3 = Double.parseDouble(System.console().readLine());
		p3 = (0.2797 * Math.pow(p3-100, 1.35));

		System.out.print("How long was the Javelin throw? ");
		p4 = Double.parseDouble(System.console().readLine());
		p4 = (10.14 * Math.pow(p4-7, 1.08));

		System.out.print("How long did it took you to run 400m? ");
		p5 = Double.parseDouble(System.console().readLine());
		p5 = (1.53775 * Math.pow(82-p5, 1.81));

		System.out.print("How long did it took you to run 110m with hurdles? ");
		p6 = Double.parseDouble(System.console().readLine());
		p6 = (5.74352 * Math.pow(28.5-p6, 1.92));

		System.out.print("How long did you jumped? ");
		p7 = Double.parseDouble(System.console().readLine());
		p7 = (0.14354 * Math.pow(p7-220, 1.40));

		System.out.print("How long did the shot put went? ");
		p8 = Double.parseDouble(System.console().readLine());
		p8 = (51.39 * Math.pow(p8-1.5, 1.05));

		System.out.print("How high did you jumped? ");
		p9 = Double.parseDouble(System.console().readLine());
		p9 = (0.8465 * Math.pow(p9-75, 1.42));

		System.out.print("How long did it took you to run 1500m? ");
		p10 = Double.parseDouble(System.console().readLine());
		p10 = (0.03768 * Math.pow(480-p10, 1.85));

		pT= (p1+p2+p3+p4+p5+p6+p7+p8+p9+p10);
		System.out.println("Performance result: " + pT);
		
	}

}
