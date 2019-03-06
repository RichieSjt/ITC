public class ci {
    public static void main (String[] args){

    double lc, wr, wh, wc, wi, wra, dr, crr, ci;

    System.out.println("Describe your perception of the following statements in a scale of -2(very low) to +2(very high)");
    System.out.println("");

    System.out.print("Level of crime: ");
    lc = Double.parseDouble(System.console().readLine());

    System.out.print("Worry about being robbed: ");
    wr = Double.parseDouble(System.console().readLine());

    System.out.print("Worry about your home being broken: ");
    wh = Double.parseDouble(System.console().readLine());

    System.out.print("Worry about your car being stolen: ");
    wc = Double.parseDouble(System.console().readLine());
    
    System.out.print("Worry about being insulted: ");
    wi = Double.parseDouble(System.console().readLine());

    System.out.print("Worry about racism: ");
    wra = Double.parseDouble(System.console().readLine());

    System.out.print("Problems with drugs in your community: ");
    dr = Double.parseDouble(System.console().readLine());

    System.out.print("Corruption problems: ");
    crr = Double.parseDouble(System.console().readLine());

    ci = (((lc+wr+wh+wc+wi+wra+dr+crr+16) * (100))/32);
    System.out.print("Crime Index of your city: " + ci);
        
    }
}
    
