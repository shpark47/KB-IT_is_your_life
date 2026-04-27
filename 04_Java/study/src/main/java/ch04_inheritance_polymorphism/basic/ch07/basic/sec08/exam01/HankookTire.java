package main.java.ch04_inheritance_polymorphism.basic.ch07.basic.sec08.exam01;

public class HankookTire extends Tire {
    @Override
    public void roll() {
        System.out.println("한국 타이어가 회전합니다.");
    }
}
