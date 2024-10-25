import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class DateServerMTP {
    public static void main(String[] args) {

        int port = Integer.parseInt(args[0]);
        
        ExecutorService threadPool = Executors.newFixedThreadPool(10); 

        try (ServerSocket serSoc = new ServerSocket(port)) {

            System.out.println("Port: " + port + " open.");

            while (true) {
                Socket soc = serSoc.accept();
                threadPool.execute(new ClientHandler(soc)); 
            }

        } catch (IOException e) {

            System.err.println(e);
        
        } finally {
            threadPool.shutdown(); 
        }
    }
}

class ClientHandler implements Runnable {
    private Socket soc;

    public ClientHandler(Socket socket) {
        this.soc = socket;
    }

    @Override
    public void run() {

        try (PrintWriter sysOut = new PrintWriter(soc.getOutputStream(), true)) {

            Thread.sleep(5000);
            sysOut.println(new java.util.Date().toString());

        } catch (IOException | InterruptedException e) {

            System.err.println(e);

        } finally {

            try {
                soc.close();
            } catch (IOException e) {
                System.err.println(e);
            }

        }
    }
}
