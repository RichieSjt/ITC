public class Water {
	public static void main (String[] args) {
		boolean a, b, c, d, e, f, g, v, w, x, y, z;

		System.out.print("Is a open? ");
		a = Boolean.parseBoolean(System.console().readLine());

		System.out.print("Is b open? ");
		b = Boolean.parseBoolean(System.console().readLine());

		System.out.print("Is c open? ");
		c = Boolean.parseBoolean(System.console().readLine());

		System.out.print("Is d open? ");
		d = Boolean.parseBoolean(System.console().readLine());

		System.out.print("Is e open? ");
		e = Boolean.parseBoolean(System.console().readLine());

		System.out.print("Is f open? ");
		f = Boolean.parseBoolean(System.console().readLine());

		System.out.print("Is g open? ");
		g = Boolean.parseBoolean(System.console().readLine());

		v = ((a==true & d==true) & (g==true));
		System.out.println("v = " + (v));

		w = ((a==true & d==true) & (g==false));
		System.out.println("w = " + (w));

		x = ((a==true & d==false) | (b==true & c==true) & (e==true));
		System.out.println("x = " + (x));

		y = (((b==true & c==true) & (e==false)) | ((b==true & c==false) & (f==true))) ;
		System.out.println("y = " + (y));

		z = ((b==true & c==false) & (f==false));
		System.out.println("z = " + (z));

	}
 
}