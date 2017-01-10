
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author DJSCE.Student
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        // TODO code application logic here
        
        PrintWriter out=null;
        Socket echoSocket=null;
        BufferedReader in=null;
        try{
            // open socket
            echoSocket = new Socket("localhost", 2500);
            // creating output stream
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            // creating input stream (using BufferedReader)
            in = new BufferedReader(new InputStreamReader(echoSocket.getInputStream()));
            
        
        }catch(Exception e){
            System.out.println(e);
        }
        BufferedReader stdIn=new BufferedReader(new InputStreamReader(System.in));
        String userInput;
        System.out.println("EchoClient Started");
        while ((userInput = stdIn.readLine()) != null)
        { // reading from stdin
            out.println(userInput); // writing to socket
            System.out.println(in.readLine()); // reading from socket & writing to stdout
        }
        out.close();
        in.close();
        stdIn.close();
        echoSocket.close();
    }
}
