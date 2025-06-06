import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server started, waiting for client...");
        Socket socket = serverSocket.accept();
        System.out.println("Client connected");

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = input.readLine()) != null) {
            System.out.println("Client: " + line);
            System.out.print("Server: ");
            String response = userInput.readLine();
            output.println(response);
            if (response.equalsIgnoreCase("bye")) break;
        }

        socket.close();
        serverSocket.close();
    }
}
