import java.net.*;
import java.io.*;

public class DateServerMT {
    public static void main(String[] args) {

        int port = Integer.parseInt(args[0]);
        
        try (ServerSocket serSoc = new ServerSocket(port)) {
            
            System.out.println("Port: " + port + " open.");

            while (true) {

                Socket soc = serSoc.accept();
                new Thread(new ClientHandler(soc)).start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

class ClientHandler implements Runnable {
    private Socket soc;

    public ClientHandler(Socket socket) {
        this.soc = socket;
    }

    @Override
    public void run() {}
}
