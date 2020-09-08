package connection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client extends Connection{

    private String localHost; //host del servidor
    private Socket socket;

    public Client(String localHost, int port) {
        super(port);
        this.localHost = localHost;
    }

    @Override
    public void startConnection() {
        try {
            socket = new Socket("192.168.100.104",port);

            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream(socket.getInputStream());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void stopConnection() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
