package main.java.ch04_inheritance_polymorphism.basic.ch07.basic.sec07.exam01;

public class PromotionExample {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();

        A a1 = b;
        A a2 = c;
        A a3 = d;
        A a4 = e;

        B b1 = d;
        C c1 = e;

//        B b3 = e; class E는 B를 상속받지 않아서
//        C c2 = d; class D는 C를 상속받지 않아서
    }
}
