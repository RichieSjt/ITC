public class Android {
    public int steps, x, y;
    public String orientation;
    public Sensor[] sensors;

    public Android() {
        orientation = "north";
        sensors = new Sensor[2];

        sensors[0] = new BatterySensor(100, 0, 100, 3);
        sensors[1] = new TemperatureSensor(50, 21, 5);
    }

    public void move(int x, int y) {
        int deltaX, deltaY;
        deltaX = x - this.x;
        deltaY = y - this.y;

        if(deltaX > 0){
            while(orientation.equals("east") == false){
                turnClockwise();
            }
        }else{
            while(orientation.equals("west") == false){
                turnCounterClockwise();
            }
        }
        walk(Math.abs(deltaX));

        if(deltaY > 0){
            while(orientation.equals("north") == false){
                turnClockwise();
            }
        }else{
            while(orientation.equals("south") == false){
                turnCounterClockwise();
            }
        }
        walk(Math.abs(deltaY));
    }

    public void walk(int steps) {
        for (int i = 0; i < steps; i++) {
            this.steps++;
            switch(orientation){
                case "north": y++; break;
                case "east": x++; break;
                case "south": y--; break;
                case "west": x--; break;
            }
            System.out.println("Heading: " + orientation);
            System.out.println("Current position: " + x + ", " + y);

            for (int j = 0; j < sensors.length; j++) {
                sensors[j].addStep();
                System.out.println(sensors[j].displayStatus());
                System.out.println(sensors[j].checkup()); 
                if (sensors[j].capable() == false) {
                    sensors[j].fix();
                }
            }
        }
    }

    public void turnClockwise() {
        switch (orientation) {
        case "north":
            orientation = "east";
            break;
        case "east":
            orientation = "south";
            break;
        case "south":
            orientation = "west";
            break;
        case "west":
            orientation = "north";
            break;
        }
    }

    public void turnCounterClockwise() {
        switch (orientation) {
        case "north":
            orientation = "west";
            break;
        case "west":
            orientation = "south";
            break;
        case "south":
            orientation = "east";
            break;
        case "east":
            orientation = "north";
            break;
        }
    }
}