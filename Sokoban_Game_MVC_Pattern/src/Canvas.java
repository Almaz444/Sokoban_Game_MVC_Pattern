import javax.swing.JPanel;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

public class Canvas extends JPanel {
    private Model model;
    private Image imageGamer;
    private Image imageWall;
    private Image imageBox;
    private Image imageGoal;
    private Levels levels;

    public Canvas(Model model) {
        levels = new Levels();
        this.model = model;
        setBackground(Color.BLACK);
        setOpaque(true);
        File fileNameImageGamer = new File("images/gamer.png");
        File fileNameImageWall = new File("images/wall.png");
        File fileNameImageBox = new File("images/box.png");
        File fileNameImageGoal = new File("images/goal.png");
        try {
            imageGamer = ImageIO.read(fileNameImageGamer);
            imageWall = ImageIO.read(fileNameImageWall);
            imageBox = ImageIO.read(fileNameImageBox);
            imageGoal = ImageIO.read(fileNameImageGoal);

        } catch (IOException ioe) {
            System.out.println(ioe);
        }
    }

    public void paint(Graphics g) {
        if (model.getStatus() == false) {
            g.setFont(new Font("TimesRoman", Font.PLAIN, 70));
            g.setColor(Color.RED);
            g.drawString("Initialization Error!!!", 100, 100);
        } else {
            super.paint(g);
            int start = 50;
            int x = start;
            int y = start;
            int width = 50;
            int height = 50;
            int offset = 0;
            int countNumber = model.getCurrentLevel();
            String level = "Level " + Integer.toString(countNumber);
            g.setFont(new Font("David", Font.PLAIN, 30));
            g.setColor(Color.BLUE);
            g.drawString(level,800 , 40);
            int[][] desktop = model.getDesktop();
            for (int i = 0; i < desktop.length; i++) {
                for (int j = 0; j < desktop[i].length; j++) {
                    if (desktop[i][j] == 1) {
                        g.drawImage(imageGamer, x, y, null);
                    } else if (desktop[i][j] == 2) {
                        g.drawImage(imageWall, x, y, null);
                    } else if (desktop[i][j] == 3) {
                        g.drawImage(imageBox, x, y, null);
                    } else if (desktop[i][j] == 4) {
                        g.drawImage(imageGoal, x, y, null);
                    }
                    x = x + width + offset;
                }
                x = start;
                y = y + height + offset;
            }

        }

    }
}
