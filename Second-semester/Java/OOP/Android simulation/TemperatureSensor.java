public class TemperatureSensor extends Sensor{
    public int currentTemperature;
    public int maxTemperature;
    public int stepsToIncrease1; 
    public int initialTemperature;
    //this. refers to the variables used in the class

    public TemperatureSensor(int maxTemperature, int initialTemperature, int stepsToIncrease1){
        this.maxTemperature = maxTemperature;
        this.initialTemperature = initialTemperature;
        this.stepsToIncrease1 = stepsToIncrease1;
        this.currentTemperature = initialTemperature;
    }

    public void increaseTemperature(){
        currentTemperature++;
    }
    public void coolDown(){
        currentTemperature = initialTemperature;
    }
    public void addStep(){
        super.addStep();
        if(steps % stepsToIncrease1 == 0)
            increaseTemperature();
    }
    public String checkup(){
        if(currentTemperature < maxTemperature){
            return super.checkup() + "temperature is stable\n";
        }else{
            return super.checkup() + "temperature reached its limit, cooling down...\n";
        }
    }
    public boolean capable(){
        return currentTemperature < maxTemperature;
    }
    public void fix(){
        coolDown();
    }
    public String displayStatus(){
        return "Current temperature: " + currentTemperature + " Celsius";
    }
}