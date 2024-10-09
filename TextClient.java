import java.net.*;
import java.io.*;
import java.util.Scanner;
public class TextClient {
    public static void main(String[] args) {
        try {
            // Accept input from the user
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a message to send to the server: ");
            String userInput = scanner.nextLine();
            // Make a connection to the server running on localhost at port 6013
            Socket sock = new Socket("127.0.0.1", 6013);
            // Send the user's input to the server
            PrintWriter pout = new PrintWriter(sock.getOutputStream(), true);
            pout.println("Client says: " + userInput);
            // Get the input stream from the socket
            InputStream in = sock.getInputStream();
            BufferedReader bin = new BufferedReader(new InputStreamReader(in));
            // Read the response from the server and print it to the console
            String line;
           
            
            while(true){ // WHILE TRUE LOOP, we dont want to stop the communiaction
                
                if( (line = bin.readLine()) != null){ // if there is something to read, we will print it. this is like the wait 
                System.out.println(line); // prints to the CLIENT terminal
                
                }
                System.out.print("Enter a message to send to the server: "); // prompts client to send emssage
                userInput = scanner.nextLine(); // stores input 
                pout.println("Client says: " + userInput); // // sends message to the stream

                if(userInput.equals("")) break; // break if no input, using .equals cause strings are objects, scanner does not store null, stores empty string
            }
           

        // Close the socket connection
            sock.close();
        } catch (IOException ioe) { System.err.println(ioe); }
    }
}