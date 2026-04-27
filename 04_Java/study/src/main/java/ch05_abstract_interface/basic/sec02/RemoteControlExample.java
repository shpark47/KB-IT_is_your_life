package main.java.ch05_abstract_interface.basic.sec02;

public class RemoteControlExample {
    public static void main(String[] args) {
        RemoteControl rc;
        rc = new Television();
        rc.turnOn();

        rc = new Audio();
        rc.turnOn();
    }
}
