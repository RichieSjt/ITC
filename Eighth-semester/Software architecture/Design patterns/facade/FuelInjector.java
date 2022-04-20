public class FuelInjector implements EnginePiece {
    @Override
    public void init() {
        System.out.println("Turning on Fuel Injector...");
    }

    @Override
    public void stop() {
        System.out.println("Turning off Fuel Injector...");
    }
}
