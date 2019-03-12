import java.util.Scanner;

public class Disturbed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int flats, i, disturb = 0;
        String input;
        String[] lights;

        flats = Integer.parseInt(sc.nextLine());
        input = sc.nextLine();
        lights = input.split(" ");

        for (i = 0; i < lights.length-2; i++) {
            if(lights[i].equals("1") && lights[i+1].equals("0") && lights[i+2].equals("1")){
                disturb = i+1;
                break; 
            }
        }
        System.out.println(disturb);

    }
}