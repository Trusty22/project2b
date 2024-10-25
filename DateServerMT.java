import java.net.*;
import java.io.*;

public class DateServerMT {

    /*
    * main makes a server socket on the specified port 1617 on my case. 
    * The server listens for client connections in an infinite loop, 
    * and each connection is done by a new thread via ClientHandler class (found some help via stack overfolw). 
    * This allows the server to manage multiple client requests concurrently, threads only no pool, thats handeled in MTP.
    */
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
/*
* This class just acts basicly as a contructor for the server, run, and clientserver.
* It gets properly used and implented in MTP
*/
class ClientHandler implements Runnable {
    private Socket soc;

    public ClientHandler(Socket socket) {
        this.soc = socket;
    }

    @Override
    public void run() {}
}
