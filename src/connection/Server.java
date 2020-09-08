package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Connection{

    private ServerSocket server;
    private Socket client;

    public Server(int port) {
        super(port);
    } // puerto del servidor

    @Override
    public void startConnection() {
        try {
            server = new ServerSocket(port);
            client = new Socket();
            client = server.accept();

            outputStream = new ObjectOutputStream(client.getOutputStream());
            inputStream = new ObjectInputStream(client.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopConnection() {
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
