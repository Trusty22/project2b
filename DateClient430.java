/**
 * Created by rtdimpsey on 4/13/17.
 */
import java.net.*;
import java.io.*;

public class DateClient430
{
    public static void main(String[] args)
    { 
        /**   if (args.length != 1) {
            System.err.println("Usage: java DateClient430 <port number>");
            System.exit(1);
        }

        int port = Integer.parseInt(args[0]); */
        try
        {
            Socket sock = new Socket("127.0.0.1",1617);
            InputStream in = sock.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            String line;
            while ((line = bin.readLine()) != null)
            {
                System.out.println(line);
            }
            sock.close();
        }
        catch (IOException ie) {}
    }
}
