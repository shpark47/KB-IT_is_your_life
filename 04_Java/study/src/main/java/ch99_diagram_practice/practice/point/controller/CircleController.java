package main.java.ch99_diagram_practice.practice.point.controller;

import main.java.ch99_diagram_practice.practice.point.model.vo.Circle;

public class CircleController {
    private Circle c = new Circle();

    public String calcArea(int x, int y, int radius) {
        c.setX(x);
        c.setY(y);
        c.setRadius(radius);
        return c.toString() + (Math.PI * radius * radius);
    }

    public String calcCircum(int x, int y, int radius) {
        c.setX(x);
        c.setY(y);
        c.setRadius(radius);
        return c.toString() + (Math.PI * radius * 2);
    }
}
