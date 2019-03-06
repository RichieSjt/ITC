public class DemoAndroid{
    public static void main(String[] args) {
        Android terminator = new Android();

        System.out.println("Where should the android move?");
        System.out.print("x: ");
        int x = Integer.parseInt(System.console().readLine());
        System.out.print("y: ");
        int y = Integer.parseInt(System.console().readLine());
        System.out.println("");

        terminator.move(x, y);

    }
}