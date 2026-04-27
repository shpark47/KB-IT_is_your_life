package main.java.ch04_inheritance_polymorphism.basic.ch07.basic.sec10.exam01;

public class SmartPhone extends Phone {
    SmartPhone(String owner) {
        super(owner);
    }

    void internetSearch() {
        System.out.println("인터넷 검색을 합니다.");
    }
}
