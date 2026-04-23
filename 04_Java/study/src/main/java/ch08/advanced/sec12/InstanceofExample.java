package main.java.ch08.advanced.sec12;

public class InstanceofExample {
    public static void main(String[] args) {
        Taxi taxi = new Taxi();
        Bus bus = new Bus();
        ride(taxi);
        bus.checkFare();
        ride(bus);
    }

    public static void ride(Vehicle v) {
        v.run();
    }
}
