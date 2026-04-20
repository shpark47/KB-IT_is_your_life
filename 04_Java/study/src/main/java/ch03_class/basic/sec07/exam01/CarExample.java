package main.java.ch03_class.basic.sec07.exam01;

public class CarExample {
    public static void main(String[] args) {
        Car myCar = new Car("그랜저", 250, "검정");

        // myCar 객체 필드값 출력
        // 값이 안담긴 이유 : Car 필드에 초기화하지 않았기 때문
        System.out.println("-------------------------------------");
        System.out.println("model : " + myCar.model);
        System.out.println("color : " + myCar.color);
        System.out.println("maxSpeed : " + myCar.maxSpeed);
        System.out.println("-------------------------------------");

        // 매개변수 2개짜리 생성자(String, int)를 이용하여 객체 생성 후
        // car 참조변수에 대입
        Car car = new Car("ㅇㅇㅇ", 100);
    }
}
