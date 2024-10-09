import java.net.*;
import java.io.*;
import java.util.Scanner;
public class TextServer {
    public static void main(String[] args) {
        try {
            // Create a server socket listening on port 6013
            ServerSocket sock = new ServerSocket(6013);
            /* Now listen for connections */
            Scanner scan = new Scanner(System.in);
            String response;
            while (true) {
                // Accept an incoming connection from a client
                Socket client = sock.accept();
                // Read the message sent by the client
                BufferedReader in = new BufferedReader(new
                InputStreamReader(client.getInputStream()));
                
                // Send a response to the client
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);
                while(true){ // while true loop to keep the communication
                    String clientMessage = in.readLine(); // reads in the message from the buffered reader which takes in the input stream
                    System.out.println(clientMessage); // prints the clients message in the server terminal                    
                    System.out.print("Enter a message to send to the client: "); // server terminal gets prompted to send message to client
                    response = scan.nextLine(); // stores message via scanner
                    pout.println("Server says: " + response); // sends message to the stream
                    if(response.equals("")) break; // using .equals cause strings are objects
                }
                // Close the client socket and continue listening for new connections
                client.close();
                sock.close(); // close the socket if we break out the loop which will throw exception
            }
        } catch (IOException ioe) { System.err.println(ioe); }
    }
}