
import java.io.*;
import java.net.Socket;

public class TestSerialization {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1",5555);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(new Test(1,"fitsum","123456"));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
