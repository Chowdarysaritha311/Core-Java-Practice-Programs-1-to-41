import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 12345);

        BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

        BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while (true) {
            System.out.print("Client: ");
            line = userInput.readLine();
            output.println(line);
            if (line.equalsIgnoreCase("bye")) break;
            System.out.println("Server: " + input.readLine());
        }

        socket.close();
    }
}
