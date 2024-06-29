package TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        /* Declarations */
        Socket clientSocket;
        PrintWriter writer;
        BufferedReader reader;

        /* Establish connection */
        clientSocket = new Socket("127.0.0.1", 4801);
        writer = new PrintWriter(clientSocket.getOutputStream(), true);
        reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String line;
        writer.println("Hello, world!"); // SEND
        line = reader.readLine(); // RECEIVE
        System.out.println("Server replied: " + line);

        writer.close();
        reader.close();
        clientSocket.close();
    }
}
