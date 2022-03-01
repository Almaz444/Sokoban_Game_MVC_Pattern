import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Controller implements KeyListener, ActionListener {
    private Model model;

    public Controller(Viewer viewer) {
        model = new Model(viewer);
    }

    public void keyPressed(KeyEvent event) {
        int keyCode = event.getKeyCode();
        switch (keyCode) {
            case 37:
                model.move("Left");
                break;
            case 38:
                model.move("Up");
                break;
            case 39:
                model.move("Right");
                break;
            case 40:
                model.move("Down");
                break;
            default:
                return;


        }
    }

    public void keyReleased(KeyEvent event) {

    }

    public void keyTyped(KeyEvent event) {

    }

    public Model getModel() {
        return model;
    }


    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("Level One")) {
            model.selectLevelFromMenu("One");
        } else if (command.equals("Level Two")) {
            model.selectLevelFromMenu("Two");
        } else if (command.equals("Level Three")) {
            model.selectLevelFromMenu("Three");
        } else if (command.equals("Level Four")) {
            model.selectLevelFromMenu("Four");
        } else if (command.equals("Level Five")) {
            model.selectLevelFromMenu("Five");
        } else if (command.equals("Level Six")) {
            model.selectLevelFromMenu("Six");
        } else if (command.equals("Level Seven")) {
            model.selectLevelFromMenu("Seven");
        } else if (command.equals("Level Eight")) {
            model.selectLevelFromMenu("Eight");
        } else if (command.equals("Level Nine")) {
            model.selectLevelFromMenu("Nine");
        }
    }
}
