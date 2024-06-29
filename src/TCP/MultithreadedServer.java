package TCP;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultithreadedServer {
    public static void main(String[] args) throws IOException {
        /* Declarations */
        ServerSocket serverSocket = null; Socket clientSocket = null;
        boolean listening = true;

        /* Bind + Listen */
        serverSocket = new ServerSocket(4801);
        System.out.println("Server is listening on port 4801...");

        while (listening) {
            /* Client socket establishes connection */
            clientSocket = serverSocket.accept();
            WorkerThread thread = new WorkerThread(clientSocket);
            thread.start();
        }

        /* Finish */
        clientSocket.close();
    }
}
