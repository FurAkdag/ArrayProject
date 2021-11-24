package my_project.model;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.GraphicalObject;
import KAGO_framework.view.DrawTool;

import java.awt.*;

/**
 * Repräsentiert eine Kugel (einen Kreis), der in eine Schlange eingefügt werden soll. Dabei muss jeder QueueBall immer
 * seinen Vorgänger kennen, damit er zu ihm Abstand halten kann.
 */
public class ArrayObject extends GraphicalObject {

    /**
     * Erzeugt einen neuen QueueBall
     * @param x Startposition x
     * @param y Startposition y
     */
    private int r;
    private boolean filled;
    private int a;
    private boolean vanish;

    private ViewController viewController;

    public ArrayObject(double posX, double posY, ViewController viewController){
        this.x = posX*50 + 100;
        this.y = posY*50 + 100;
        a = 255;
        r = 10;
        filled = false;
        vanish = false;
        this.viewController = viewController;
        viewController.draw(this);

    }


    /**
     * Selbsterklärend: zeichnet den QueueBall. Wird vom Framework automatisch aufgerufen (jede Frame 1x).
     */
    @Override
    public void draw(DrawTool drawTool) {
        if(filled){
            drawTool.setCurrentColor(255,0,0,a);
        }else{
            drawTool.setCurrentColor(0,0,0,255);
        }

        drawTool.drawFilledCircle(x, y, r);
    }

    public void getBigger(){
        if(r < 25){
            r += 5;
        }
    }

    public void getSmaller(){
        if(r > 5){
            r -= 5;
        }
    }

    public void fill(){
        filled = true;
    }

    public void delete(){
        filled = false;
        r = 10;
        a = 255;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setVanish(boolean vanish) {
        this.vanish = vanish;
    }

    public boolean isVanish() {
        return vanish;
    }

    /**
     * Wird mit jeder Frame vom Framework aufgerufen und dient zur Manipulation des Objekts im Verlauf
     * der Zeit.
     * @param dt die Sekunden, die seit dem letzten Aufruf von update vergangen sind
     */
    @Override
    public void update(double dt){
        if(filled) {
            if (vanish) {

                a -= 300 * dt;
                a = Math.max(0, a);
            } else {
                a += 300 * dt;
                a = Math.min(255, a);
            }
        }
    }

}


