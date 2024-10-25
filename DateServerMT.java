import java.net.*;
import java.io.*;

public class DateServerMT {
    public static void main(String[] args) {
        int port = Integer.parseInt(args[0]);
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server listening on port " + port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                new Thread(new ClientHandler(clientSocket)).start();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket socket) {
        this.clientSocket = socket;
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            // Simulate 5000ms of work
            Thread.sleep(5000);
            // Write the current date to the socket
            out.println(new java.util.Date().toString());
        } catch (IOException | InterruptedException e) {
            System.err.println(e);
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}
