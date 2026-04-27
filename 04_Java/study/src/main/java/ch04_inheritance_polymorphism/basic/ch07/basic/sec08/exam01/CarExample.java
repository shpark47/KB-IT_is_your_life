package main.java.ch04_inheritance_polymorphism.basic.ch07.basic.sec08.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car();
        myCar.tire = new Tire();
        myCar.run();
        myCar.tire = new HankookTire();
        myCar.run();
        myCar.tire = new KumhoTire();
        myCar.run();
    }
}
