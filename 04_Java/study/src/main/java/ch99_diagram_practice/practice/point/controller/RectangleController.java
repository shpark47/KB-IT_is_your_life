package main.java.ch99_diagram_practice.practice.point.controller;

import main.java.ch99_diagram_practice.practice.point.model.vo.Rectangle;

public class RectangleController {
    private Rectangle r = new Rectangle();

    public String calcArea(int x, int y, int height, int width) {
        r.setX(x);
        r.setY(y);
        r.setHeight(height);
        r.setWidth(width);
        return r.toString() + (width * height);
    }

    public String calcPerimeter(int x, int y, int height, int width) {
        r.setX(x);
        r.setY(y);
        r.setHeight(height);
        r.setWidth(width);
        return r.toString() + ((width + height) * 2);
    }
}
