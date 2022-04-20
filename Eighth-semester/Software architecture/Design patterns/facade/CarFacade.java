public class CarFacade {
    EnginePiece fuelInjector = new FuelInjector();
    EnginePiece coolingController = new CoolingController();
    
    public void startEngine() {
        System.out.println("\nStarting Engine");
        fuelInjector.init();
        coolingController.init();
    }   

    public void stopEngine() {
        System.out.println("\nStopping Engine");
        fuelInjector.stop();
        coolingController.stop();
    }
}