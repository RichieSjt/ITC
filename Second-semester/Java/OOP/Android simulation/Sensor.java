public class Sensor{
    public int steps;

    public boolean capable(){
        return true;
    }
    public void addStep(){
        steps++;
    }
    public String checkup(){
        return "The ";
    }
    public String displayStatus(){
        return "Steps: " + steps;
    }
    public void fix(){
    }
}
