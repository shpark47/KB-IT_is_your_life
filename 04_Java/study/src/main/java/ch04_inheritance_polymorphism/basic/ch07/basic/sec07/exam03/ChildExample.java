package main.java.ch04_inheritance_polymorphism.basic.ch07.basic.sec07.exam03;

public class ChildExample {
    public static void main(String[] args) {
        Parent parent = new Child();
        parent.field1 = "data1";
        parent.method1();
        parent.method2();
//        parent.field2 = "data2"; Parent 에는 없어서 Parent 형식으론 못씀
//        parent.method3();
        Child child = (Child) parent;
        child.field2 = "data2";
        child.method3();
    }
}
