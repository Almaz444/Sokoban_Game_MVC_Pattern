import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LevelsFromFile {

    public LevelsFromFile() {
    }

    public int[][] nextLevel(String fileName) throws Exception {
        File file = new File(fileName);
        String contentFile = getContentFile(file);
        int[][] desktop = convertStringIntoTwoDimensionArray(contentFile);
        return desktop;
    }


    private int[][] convertStringIntoTwoDimensionArray(String line) {
        int n = line.length();
        int row = 0;
        for (int i = 0; i < n; i++) {
            char symbol = line.charAt(i);
            if (symbol == '\n') {
                row = row + 1;
            }
        }
        int[][] array = new int[row][];
        int column = 0;
        int index = 0;
        for (int i = 0; i < n; i++) {
            char symbol = line.charAt(i);
            if (symbol != '\n') {
                column = column + 1;
            } else if (symbol == '\n') {
                array[index] = new int[column];
                index = index + 1;
                column = 0;
            }
        }
        row = 0;
        column = 0;
        for (int i = 0; i < line.length(); i++) {
            char symbol = line.charAt(i);
            if (symbol != '\n') {
                array[row][column] = Integer.parseInt("" + symbol);
                column = column + 1;
            } else if (symbol == '\n') {
                row = row + 1;
                column = 0;
            }
        }
        return array;
    }

    private String getContentFile(File file) throws Exception {
        try (FileInputStream in = new FileInputStream(file)) {
            int size = (int) file.length();
            char[] array = new char[size];
            int index = 0;
            int unicode;
            while ((unicode = in.read()) != -1) {
                char symbol = (char) unicode;
                if (('0' <= symbol && symbol <= '4') || symbol == '\n') {
                    array[index] = symbol;
                    index = index + 1;
                }
            }
            String content = new String(array, 0, index);
            return content;
        } catch (FileNotFoundException fnfe) {
            throw new Exception("File Not Found Exception: " + fnfe);
        } catch (IOException ioe) {
            throw new Exception("Basic I/O Exception: " + ioe);
        }

    }


}

