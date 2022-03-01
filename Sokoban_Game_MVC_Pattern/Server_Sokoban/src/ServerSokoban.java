import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;


public class ServerSokoban {

    private ServerSocket serverSocket;
    private static final Object object = new Object();

    public ServerSokoban(int portNumber) {
        try {
            serverSocket = new ServerSocket(portNumber);
        } catch (IOException ioe) {
            System.out.println("Error " + ioe);
        }

    }

    public void go() {
        System.out.println("The Server has been started.");
        while (true) {
            synchronized (object) {
                Socket clientSocket;
                try {
                    clientSocket = serverSocket.accept();
                } catch (IOException ioe) {
                    System.out.println("Error " + ioe);
                    clientSocket = null;
                }
                if(clientSocket != null) {

                    MyClient client = new MyClient(clientSocket);
                    Thread thread = new Thread(client);
                    thread.start();
                }

            }

        }
    }

}



