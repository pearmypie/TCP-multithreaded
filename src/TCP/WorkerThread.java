package TCP;

import java.io.*;
import java.net.Socket;

public class WorkerThread extends Thread {
    private Socket clientSocket;

    /* Generated Constructor */
    public WorkerThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        /* Declarations */
        PrintWriter writer;
        BufferedReader reader;
        String inputLine, outputLine;

        /* Process request */
        System.out.println("Client connected!\nAddress: " + clientSocket.getInetAddress().toString() +"\nPort: " + clientSocket.getPort());

        try {
            reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            writer = new PrintWriter(clientSocket.getOutputStream(), true);

            while ((inputLine = reader.readLine()) != null) {
                System.out.println(inputLine);
                outputLine = "OK";
                writer.println(outputLine);
                writer.flush();

                //if (outputLine.compareTo("Done") == 0) { listening = false; }
            }

            writer.close();
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
