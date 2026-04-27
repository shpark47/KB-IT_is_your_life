package main.java.ch04_inheritance_polymorphism.basic.ch07.basic.sec04.exam01;

public class Computer extends Calculator{
    @Override
    public double areaCircle(double r) {
        return Math.PI * r * r;
    }
}
