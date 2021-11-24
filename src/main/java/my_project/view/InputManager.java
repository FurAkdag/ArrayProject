package my_project.view;

import KAGO_framework.control.ViewController;
import KAGO_framework.model.InteractiveGraphicalObject;
import my_project.control.ProgramController;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Realisiert ein Objekt, dass alle Eingaben empfängt und dann danach passende Methoden
 * im ProgramController aufruft
 */
public class InputManager extends InteractiveGraphicalObject {

    private ProgramController programController;
    private ViewController viewController;
    /**
     * Objekterzeugung
     * @param programController Nötig als Objekt vom Controllerbereich, das informiert wird
     * @param viewController Nötig, um den Aufruf der Interface-Methoden sicherzustellen
     */
    public InputManager(ProgramController programController, ViewController viewController){
        this.programController = programController;
        this.viewController = viewController;
        viewController.register(this);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void keyReleased(int key) {
        if(key == KeyEvent.VK_A) {
            programController.moveCurrent("left");
        }else if(key == KeyEvent.VK_D){
            programController.moveCurrent("right");
        }else if(key == KeyEvent.VK_S){
            programController.moveCurrent("down");
        }else if(key == KeyEvent.VK_W){
            programController.moveCurrent("up");
        }
        /*else if(key == KeyEvent.VK_S){
            programController.addBallToLast();
        }else if(key == KeyEvent.VK_R){
            programController.removeBallFromCurrent();
        }else if(key == KeyEvent.VK_C){
            programController.changeCurrent();
        }else if(key == KeyEvent.VK_B){
            programController.returnCurrent();
        }*/
    }
}
