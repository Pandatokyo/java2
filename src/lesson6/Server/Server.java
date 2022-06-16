package lesson6.Server;
import java.io.IOException;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(9000);
            do {
                socket = server.accept();
                System.out.println("client connected");
                new Thread(new ClientHandler(socket)).start();
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert socket != null;
                socket.close();
                server.close();
                System.out.println("closing server");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
