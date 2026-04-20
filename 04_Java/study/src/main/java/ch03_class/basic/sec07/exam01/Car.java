package main.java.ch03_class.basic.sec07.exam01;

public class Car {
    // 속성(==필드)
    String model;
    String color;
    int maxSpeed;

    // 기능(==생성자 + 메서드)
    // 생성자 : new 연산자를 통해서 객체가 생성될 때
    //        생성된 객체의 필드값 초기화 + 기능 수행 역할

    // 기본 생성자
    public Car() {
        System.out.println("기본 생성자로 Car 객체 생성");
    }

    // 매개변수 생성자
    // ** 매개변수 : 생성자나 메소드 호출 시 ()안에 작성되어
    //             전달되는 값을 저장하는 변수
    public Car(String model) {
        System.out.println("매개변수 1개 생성자");
    }

    public Car(String model, String color) {
        System.out.println("매개변수 2개 생성자");
    }

    public Car(String model, String color, int maxSpeed) {
        System.out.println("매개변수 3개 생성자");
        System.out.println("model : " + model);
        System.out.println("color : " + color);
        System.out.println("maxSpeed : " + maxSpeed);

        // 전달 받은 값을 필드에 초기화
        // - 객체가 자기 자신을 참조할 수 있도록 하는 변수
        // - 모든 객체 내부에 숨겨져 있다.

        // 사용 이유??
        // -> 필드명과 매개변수명이 같을 경우
        //    이를 구분하기 위해서 주로 사용함

        // ** this 참조 변수 **
        this.model = model;
        // 필드 = 매개변수
        // 현재 객체가 가지고 있는 필드 model(this.model)에
        // 매개변수 model 값을 대입
        this.color = color;
        this.maxSpeed = maxSpeed;
    }

    // ** 오버로딩 (Over Loading) **
    // - 클래스 내에 동일한 이름의 메소드(생성자 포함)를 여러개 작성하는 기법

    // -> 하나의 이름으로 여러 기능을 수행할 수 있게 하는 것

    // [오버로딩 조건]
    // 1. 메소드(생성자 포함)의 이름이 동일
    // 2. 매개변수의 개수, 타입, 순서 중 1개라도 달라야 함

    // 매개변수의 개수, 타입이 같지만 순서가 다름 -> 오버로딩 성립
    public Car(String model, int maxSpeed, String color) {
//        System.out.println("this 생성자");
        // Call to 'this()' must be first statement in constructor body
        // (주의) this 생성자는 반드시 첫 줄에 작성되어야 한다.

        this(model, maxSpeed);
        // this 생성자 : 현재 객체의 다른 생성자 호출
        // this() 사용 이유 : 중복 코드 제거, 코드 길이 감소, 재사용성 증가
        // (가독성이 어려운 경우가 생길 수 있어서 많이 사용되지는 않음)

//        this.model = model;
//        this.maxSpeed = maxSpeed;
        this.color = color;
    }

    // 개수, 타입이 다르므로 오버로딩 성립
    public Car(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;

        System.out.println("오버로딩 적용");
    }

    // public Car(String brand, int minSpeed) {}
    // 매개변수명은 다르지만 개수, 타입, 순서가 동일하기 때문에 에러 발생
    // -> 매개변수명은 신경 X
}
