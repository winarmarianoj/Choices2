package connection;

import entity.Choices;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public abstract class Connection {

    protected int port;
    protected ObjectInputStream inputStream;
    protected ObjectOutputStream outputStream;

    public Connection(int port) {
        this.port = port;
    }

    public abstract void startConnection();
    public abstract void stopConnection();

    public void sendChoice(Choices choices){
        try {
            outputStream.writeObject(choices);
            outputStream.reset();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Choices haveChoices(){
        try {
            return (Choices) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
