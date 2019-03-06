public class BatterySensor extends Sensor{
    public int initialCapacity;
    public int maxCapacity;
    public int currentCapacity;
    public int minCapacity; 
    public int stepsToDecrease1;

    public BatterySensor(int maxCapacity, int minCapacity, int initialCapacity, 
    int stepsToDecrease1){
        this.maxCapacity = maxCapacity;
        this.minCapacity = minCapacity;
        this.initialCapacity = initialCapacity;
        this.stepsToDecrease1 = stepsToDecrease1;
        this.currentCapacity = initialCapacity; 
    }

    public int measureCapacity(){
        return currentCapacity;
    }
    public void addStep(){
        super.addStep();
        if(steps % stepsToDecrease1 == 0){
            diminishCapacity();
        }
    }
    public void diminishCapacity(){
        currentCapacity--; 
    }
    public void recharge(){
        currentCapacity = maxCapacity;
    }
    public String checkup(){
        if(currentCapacity > minCapacity){
            return super.checkup() + "battery still has energy";
        }else{
            return super.checkup() + "battery is depleted, recharging...";
        }
    }
    public boolean capable(){
        return currentCapacity > minCapacity; 
    }
    public void fix(){
        recharge();
    }

    public String displayStatus(){
        return super.displayStatus() + "\nBattery capacity: " + currentCapacity + "%";
        //super can use the methods of the parent class
    }
}