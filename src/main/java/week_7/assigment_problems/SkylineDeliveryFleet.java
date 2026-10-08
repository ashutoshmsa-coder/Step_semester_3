package week_7.assigment_problems;

abstract class Drone {
    public abstract String fly();
}

interface Trackable {
    String getLocation();
}

class DeliveryDrone extends Drone implements Trackable {
    private String id;
    private String location;

    public DeliveryDrone(String id, String location) {
        this.id = id;
        this.location = location;
    }

    @Override
    public String fly() {
        return "Delivery drone " + id + " flying";
    }

    @Override
    public String getLocation() {
        return location;
    }
}

class ScoutDrone extends Drone {
    private String id;

    public ScoutDrone(String id) {
        this.id = id;
    }

    @Override
    public String fly() {
        return "Scout drone " + id + " flying";
    }
}

class GroundRobot implements Trackable {
    private String id;
    private String location;

    public GroundRobot(String id, String location) {
        this.id = id;
        this.location = location;
    }

    @Override
    public String getLocation() {
        return location;
    }
}

public class SkylineDeliveryFleet {

    public static String getLocationIfTrackable(Object o) {
        if (o instanceof Trackable) {
            Trackable t = (Trackable) o;
            return t.getLocation();
        }

        return "Not trackable";
    }

    public static void main(String[] args) {
        DeliveryDrone d = new DeliveryDrone("D-101", "Warehouse");
        ScoutDrone s = new ScoutDrone("S-202");
        GroundRobot g = new GroundRobot("R-303", "Delivery Hub");

        System.out.println(d.fly());
        System.out.println(s.fly());

        System.out.println(getLocationIfTrackable(d));
        System.out.println(getLocationIfTrackable(s));
        System.out.println(getLocationIfTrackable(g));
    }
}