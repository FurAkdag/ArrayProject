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
    private int arrayX;
    private int arrayY;
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
        current = new Current(75,75,viewController);
        new InputManager(this, viewController);
        arrayX = 0;
        arrayY = 0;
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
                if(arrayY != 0) {
                    current.addY(-50);
                    arrayY--;
                }
                break;
            case "down":
                if(arrayY != 4) {
                    current.addY(50);
                    arrayY++;
                }
                break;
            case "right":
                if(arrayX != 9) {
                    current.addX(50);
                    arrayX++;
                }
                break;
            case "left":
                if(arrayX != 0) {
                    current.addX(-50);
                    arrayX--;
                }
                break;
        }
    }

    public void setSize(String size){
        if(field[arrayY][arrayX].isFilled()) {
            if (size.equals("Bigger")) {
                field[arrayY][arrayX].getBigger();
            } else if (size.equals("Smaller")) {
                field[arrayY][arrayX].getSmaller();
            }
        }
    }

    public void setEverySize(String size){
        if(field[arrayY][arrayX].isFilled()) {
            if (size.equals("All Bigger")) {
                for(int i = 0;i < 10;i++){
                    for(int j = 0;j < 5; j++){
                        field[j][i].getBigger();
                    }
                }
            } else if (size.equals("All Smaller")) {
                for(int i = 0;i < 10;i++){
                    for(int j = 0;j < 5; j++){
                        field[j][i].getSmaller();
                    }
                }
            }
        }
    }

    public void fillIt(){
        field[arrayY][arrayX].fill();
    }

    public void fillAll(){
        for(int i = 0;i < 10;i++){
            for(int j = 0;j < 5; j++){
                field[j][i].fill();
            }
        }
    }

    public void deleteAll(){
        for(int i = 0;i < 10;i++){
            for(int j = 0;j < 5; j++){
                field[j][i].delete();
            }
        }
    }

    public void deleteIT(){
        field[arrayY][arrayX].delete();
    }
    /**
     * Aufruf mit jeder Frame
     * @param dt Zeit seit letzter Frame
     */
    public void visibility(){
        if(field[arrayY][arrayX].isVanish()){
            field[arrayY][arrayX].setVanish(false);
        }else{
            field[arrayY][arrayX].setVanish(true);
        }
    }

    public void allGone(){
        for(int i = 0;i < 10;i++){
            for(int j = 0;j < 5; j++){
                field[j][i].setVanish(true);
            }
        }
    }

    public void getBack(){
        for(int i = 0;i < 10;i++){
            for(int j = 0;j < 5; j++){
                field[j][i].setVanish(false);
            }
        }
    }

    public void updateProgram(double dt){

    }
}
