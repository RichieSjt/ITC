public class CoolingController implements EnginePiece {
    @Override
    public void init() {
        System.out.println("Turning on Cooling controller...");
    }

    @Override
    public void stop() {
        System.out.println("Turning off Cooling controller...");
    }
}
