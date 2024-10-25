import java.net.*;
import java.io.*;
import java.util.concurrent.*;

public class DateServerMTP {

    /*
    * Makes a server socket on the specified port 1617 at my case and 
    * creates a thread pool to handle multiple client connections this preps of a thread pool.
    * Each connection is done by the the ClientHandler class, which sends the 
    * current date to the client. The server socket listens for  connections
    * in an  loop, and each accepts each new connection which is passed through the thread pool.
    */
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
    /*
    *  Run  handles the client connections its overided from the worker class to be able 
    * to work with clienthandeler runable. It simulates a delay of 5 seconds 
    * before sending the  date to the client by PrintWriter( I got some help from stackoverflow).
    * If there are any IOException or InterruptedException that happens, it is caught. Finally, 
    * makes sure that the client socket is closed after handling the requests.
    * 
    * Also this overides from the worker class leaving worker more of a contructor class which is
    * modified here.
    */
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
