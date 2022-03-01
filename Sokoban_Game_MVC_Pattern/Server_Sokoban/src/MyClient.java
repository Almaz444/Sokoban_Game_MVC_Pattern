import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.io.BufferedReader;

public class MyClient implements Runnable {

    private Socket socket;
    private LevelsFromServer levelsFromServer;

    public MyClient(Socket socket) {
        this.socket = socket;
        levelsFromServer = new LevelsFromServer();
    }

    public void run() {
        System.out.println("socket = " + socket);
        try {
            OutputStream outputStream = socket.getOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(outputStream);
            InputStreamReader inputStreamReader = new InputStreamReader(socket.getInputStream());
            BufferedReader in = new BufferedReader(inputStreamReader);
            String levelFromClientChoose = in.readLine();
            if (levelFromClientChoose.equals("Seven")) {
                levelsFromServer.setLevel(7);
            } else if (levelFromClientChoose.equals("Eight")) {
                levelsFromServer.setLevel(8);
            } else if (levelFromClientChoose.equals("Nine")) {
                levelsFromServer.setLevel(9);
            }
            DataFromServer data = new DataFromServer(levelsFromServer.nextLevel());
            out.writeObject(data);
            socket.close();
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }
    }
}


