/**
 * Created by rtdimpsey on 4/13/17.
 */
import java.net.*;
import java.io.*;

public class DateClient430
{
    public static void main(String[] args)
    { 
        
        try
        {
            

            Socket sock = new Socket("127.0.0.1",1617); // changed the port to my student id
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
