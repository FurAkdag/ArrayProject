package my_project.control;

import KAGO_framework.control.ViewController;
import my_project.model.ArrayObject;
import my_project.model.Current;
import my_project.view.InputManager;

/**
 * Ein Objekt der Klasse ProgramController dient dazu das Programm zu steuern. Die updateProgram - Methode wird
 * mit jeder Frame im laufenden Programm aufgerufen.
 */
public class ProgramController {

    //Attribute


    // Referenzen
    private ViewController viewController;  // diese Referenz soll auf ein Objekt der Klasse viewController zeigen. Über dieses Objekt wird das Fenster gesteuert.
    private ArrayObject[][] field;
    private Current current;
    /**
     * Konstruktor
     * Dieser legt das Objekt der Klasse ProgramController an, das den Programmfluss steuert.
     * Damit der ProgramController auf das Fenster zugreifen kann, benötigt er eine Referenz auf das Objekt
     * der Klasse viewController. Diese wird als Parameter übergeben.
     * @param viewController das viewController-Objekt des Programms
     */
    public ProgramController(ViewController viewController){
        this.viewController = viewController;
        field = new ArrayObject[5][10];
        current = new Current(90,90,viewController);
        new InputManager(this, viewController);
    }

    /**
     * Diese Methode wird genau ein mal nach Programmstart aufgerufen.
     * Sie erstellt die leeren Datenstrukturen, zu Beginn nur eine Queue
     */
    public void startProgram() {
        for(int i = 0;i < 10;i++){
            for(int j = 0;j < 5; j++){
                field[j][i] = new ArrayObject(i,j,viewController);
            }
        }
    }

    public void moveCurrent(String pos){
        switch (pos){
            case "up":
                if(current.getY() < 90) current.addY(-50); break;
            case "down":
                if(current.getY() < 290) current.addY(50); break;
            case "right":
                if(current.getX() < 590) current.addX(50); break;
            case "left":
                if(current.getX() < 90) current.addX(-50); break;
        }
    }
    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void updateProgram(double dt){

    }
}
