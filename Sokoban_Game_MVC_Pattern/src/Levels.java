import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Levels {
    private int level;
    private LevelsFromFile levelsFromFile;
    private static String hostName = "194.152.37.7";
    private static int portNumber = 4446;

    public Levels() {
        level = 1;
        levelsFromFile = new LevelsFromFile();
    }

    public int[][] nextLevel() {
        int[][] desktop = null;
        switch (level) {
            case 1:
                desktop = getFirstLevel();
                break;
            case 2:
                desktop = getSecondLevel();
                break;
            case 3:
                desktop = getThirdLevel();
                break;
            case 4:
                desktop = getFileDesktop("levels/level4.sok");
                break;
            case 5:
                desktop = getFileDesktop("levels/level5.sok");
                break;
            case 6:
                desktop = getFileDesktop("levels/level6.sok");
                break;
            case 7:
                desktop = getServerDesktop("Seven");
                break;
            case 8:
                desktop = getServerDesktop("Eight");
                break;
            case 9:
                desktop = getServerDesktop("Nine");
                break;
            default:
                level = 1;
                desktop = getFirstLevel();
                break;
        }
        level = level + 1;
        return desktop;
    }

    private int[][] getFirstLevel() {
        int[][] levelOne = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 0, 4, 3, 0, 2, 0, 0, 0, 2},
                {2, 0, 2, 0, 0, 2, 0, 3, 4, 2},
                {2, 0, 2, 0, 1, 0, 0, 0, 2, 2},
                {2, 0, 0, 0, 0, 0, 2, 2, 0, 2},
                {2, 0, 4, 2, 3, 0, 4, 0, 0, 2},
                {2, 0, 0, 3, 0, 2, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return levelOne;

    }

    private int[][] getSecondLevel() {
        int[][] levelTwo = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 4, 4, 0, 0, 2, 0, 0, 0, 0, 0, 2, 2},
                {2, 4, 4, 0, 0, 2, 0, 3, 0, 0, 3, 0, 2},
                {2, 4, 4, 0, 0, 2, 3, 2, 2, 2, 2, 0, 2},
                {2, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 2, 0, 2, 0, 2, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 3, 0, 2},
                {2, 2, 2, 0, 0, 0, 0, 3, 0, 0, 0, 0, 2},
                {2, 0, 3, 0, 0, 0, 0, 2, 0, 0, 0, 0, 2},
                {2, 0, 0, 0, 0, 2, 0, 2, 0, 2, 0, 0, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return levelTwo;
    }

    private int[][] getThirdLevel() {
        int[][] levelThree = new int[][]{
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2},
                {2, 2, 0, 3, 0, 0, 1, 0, 0, 2, 0, 0, 2},
                {2, 2, 0, 0, 0, 0, 2, 0, 3, 0, 3, 0, 2},
                {2, 2, 2, 0, 0, 0, 2, 2, 3, 0, 0, 3, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 0, 3, 0, 2, 0, 2, 2},
                {2, 4, 4, 4, 0, 0, 2, 0, 3, 0, 0, 0, 0, 2},
                {2, 2, 4, 4, 0, 0, 0, 3, 0, 0, 0, 0, 0, 2},
                {2, 4, 4, 4, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2},
                {2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}
        };
        return levelThree;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }


    public int[][] getServerDesktop(String level) {
        int[][] desktop;
        try (
                Socket socket = new Socket(hostName, portNumber);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        ) {
            out.println(level);
            DataFromServer desktopServer = (DataFromServer) in.readObject();
            desktop = desktopServer.getDesktop();

            return desktop;
        } catch (ClassNotFoundException cnfe) {
            System.out.println("Error: " + cnfe);
            setLevel(1);
            return desktop = nextLevel();
        } catch (IOException ioe) {
            System.out.println("Error: " + ioe);
            setLevel(1);
            return desktop = nextLevel();
        }

    }

    public int[][] getFileDesktop(String level) {
        int[][] desktop;
        try {
            desktop = levelsFromFile.nextLevel(level);
        } catch (Exception exc) {
            System.out.println("Error: " + exc);
            desktop = nextLevel();
        }
        return desktop;
    }

}
