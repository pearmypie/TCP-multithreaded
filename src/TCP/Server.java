package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        /* Declarations */
        ServerSocket serverSocket = null; Socket clientSocket = null; boolean listening = true;

        OutputStream os; PrintWriter writer;
        InputStream is; BufferedReader reader;
        String inputLine, outputLine;

        /* Bind + Listen */
        serverSocket = new ServerSocket(4801);
        System.out.println("Server is listening on port 4801...");

        while (listening) {
            /* Client socket establishes connection */
            clientSocket = serverSocket.accept();

            /* Process request (all requests in a single thread) */
            System.out.println("Client connected!\nAddress: " + clientSocket.getInetAddress().toString() +"\nPort: " + clientSocket.getPort());

            is = clientSocket.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));

            os = clientSocket.getOutputStream();
            writer = new PrintWriter(os, true);

            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
                outputLine = "OK";
                writer.println(outputLine);
                writer.flush();

                //if (outputLine.compareTo("Done") == 0) { listening = false; }
            }

            writer.close();
            reader.close();

            /* Finish */
            clientSocket.close();
        }
    }
}
