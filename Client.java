import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1"; // IP address of the server
        int serverPort = 8080; // Port number of the server

        try {
            // Create a socket and establish a connection to the server
            Socket socket = new Socket(serverIP, serverPort);
            System.out.println("Connected to server: " + socket.getInetAddress());

            // Get the input and output streams for communication
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            // Send data to the server
            String clientData = "Hello, server! This is the client.";
            outputStream.write(clientData.getBytes());
            outputStream.flush();

            // Receive the server's response
            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);
            String serverResponse = new String(buffer, 0, bytesRead);
            System.out.println("Received from server: " + serverResponse);

            // Close the connection
            inputStream.close();
            outputStream.close();
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
