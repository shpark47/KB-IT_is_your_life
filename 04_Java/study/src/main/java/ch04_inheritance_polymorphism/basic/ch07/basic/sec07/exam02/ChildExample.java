package main.java.ch04_inheritance_polymorphism.basic.ch07.basic.sec07.exam02;

public class ChildExample {
    public static void main(String[] args) {
        Child child = new Child();
        Parent parent = child;
        parent.method1();
        parent.method2();
//        parent.method3(); Parent class에는 method3 메서드가 없어서
    }
}
