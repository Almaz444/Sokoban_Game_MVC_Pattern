import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;

public class Viewer {
    private Canvas canvas;
    private JFrame frame;

    public Viewer() {
        Controller controller = new Controller(this);
        Model model = controller.getModel();
        canvas = new Canvas(model);

        JMenuItem chooseLevelOne = new JMenuItem("Level 1");
        chooseLevelOne.addActionListener(controller);
        chooseLevelOne.setActionCommand("Level One");

        JMenuItem chooseLevelTwo = new JMenuItem("Level 2");
        chooseLevelTwo.addActionListener(controller);
        chooseLevelTwo.setActionCommand("Level Two");

        JMenuItem chooseLevelThree = new JMenuItem("Level 3");
        chooseLevelThree.addActionListener(controller);
        chooseLevelThree.setActionCommand("Level Three");

        JMenuItem chooseLevelFour = new JMenuItem("Level 4");
        chooseLevelFour.addActionListener(controller);
        chooseLevelFour.setActionCommand("Level Four");

        JMenuItem chooseLevelFive = new JMenuItem("Level 5");
        chooseLevelFive.addActionListener(controller);
        chooseLevelFive.setActionCommand("Level Five");

        JMenuItem chooseLevelSix = new JMenuItem("Level 6");
        chooseLevelSix.addActionListener(controller);
        chooseLevelSix.setActionCommand("Level Six");

        JMenuItem chooseLevelSeven = new JMenuItem("Level 7");
        chooseLevelSeven.addActionListener(controller);
        chooseLevelSeven.setActionCommand("Level Seven");

        JMenuItem chooseLevelEight = new JMenuItem("Level 8");
        chooseLevelEight.addActionListener(controller);
        chooseLevelEight.setActionCommand("Level Eight");

        JMenuItem chooseLevelNine = new JMenuItem("Level 9");
        chooseLevelNine.addActionListener(controller);
        chooseLevelNine.setActionCommand("Level Nine");

        JMenu menuLevels = new JMenu("Levels");
        menuLevels.add(chooseLevelOne);
        menuLevels.add(chooseLevelTwo);
        menuLevels.add(chooseLevelThree);
        menuLevels.add(chooseLevelFour);
        menuLevels.add(chooseLevelFive);
        menuLevels.add(chooseLevelSix);
        menuLevels.add(chooseLevelSeven);
        menuLevels.add(chooseLevelEight);
        menuLevels.add(chooseLevelNine);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menuLevels);

        frame = new JFrame("Sokoban Game MVc Pattern");
        frame.setSize(1050, 800);
        frame.add("Center", canvas);
        frame.setJMenuBar(menuBar);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addKeyListener(controller);

    }

    public void update() {
        canvas.repaint();
    }

    public boolean showDialogWon() {
        JOptionPane.showMessageDialog(frame, "You are winner!");
        return true;
    }
}
