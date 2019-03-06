public class DemoTesla {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle();
        v1.color = "Blue";
        v1.brand = "Tesla";
        v1.tireSize = "20 in";
        v1.torque = "100 Nn/m";
        v1.autopilot = true;

        Report r = new Report();
        r.time60mph = 2.5;
        r.autopilotWorking = true;
        r.maxSpeed = 155;

        v1.setReport(r);
        boolean result = v1.checkup();
        System.out.println(result);
    }
}