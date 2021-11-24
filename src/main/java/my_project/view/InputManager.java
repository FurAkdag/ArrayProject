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
        if(key == KeyEvent.VK_LEFT) {
            programController.moveCurrent("left");
        }else if(key == KeyEvent.VK_RIGHT){
            programController.moveCurrent("right");
        }else if(key == KeyEvent.VK_DOWN){
            programController.moveCurrent("down");
        }else if(key == KeyEvent.VK_UP){
            programController.moveCurrent("up");
        }else if(key == KeyEvent.VK_W){
            programController.setSize("Bigger");
        }else if(key == KeyEvent.VK_S){
            programController.setSize("Smaller");
        }else if(key == KeyEvent.VK_Z){
            programController.setEverySize("All Bigger");
        }else if(key == KeyEvent.VK_H){
            programController.setEverySize("All Smaller");
        }else if(key == KeyEvent.VK_F){
            programController.fillIt();
        }else if(key == KeyEvent.VK_G){
            programController.deleteIT();
        }else if(key == KeyEvent.VK_E){
            programController.fillAll();
        }else if(key == KeyEvent.VK_R){
            programController.deleteAll();
        }else if(key == KeyEvent.VK_A){
            programController.visibility();
        }else if(key == KeyEvent.VK_C){
            programController.getBack();
        }else if(key == KeyEvent.VK_V){
            programController.allGone();
        }
    }
}
