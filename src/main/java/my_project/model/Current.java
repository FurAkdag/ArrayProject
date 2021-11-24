package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

public class Current extends GraphicalObject {

    private double x;
    private double y;
    private ViewController viewController;

    public Current(double x, double y, ViewController viewController){
        this.x = x;
        this.y = y;
        this.viewController = viewController;
        viewController.draw(this);
    }

    @Override
    public void draw(DrawTool drawTool) {
        drawTool.setCurrentColor(Color.RED);
        drawTool.drawRectangle(x,y,50,50);
    }

    public void addY(double add) {
        y += add;
    }

    public void addX(double add) {
        x += add;
    }

    public void invisible(){
        viewController.removeDrawable(this);
    }

    public void visible(){
        viewController.draw(this);
    }
}