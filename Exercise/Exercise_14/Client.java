package Exercise.Exercise_14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 12345);
            PrintWriter output = new PrintWriter(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Welcome to ParrotServer, on Port: " + socket.getPort());
            System.out.println("type 'exit' to quit");

            while(true) {
                System.out.println("Enter message: ");
                String message = scanner.nextLine();

                output.println(message);
                output.flush();
                if(message.equals("exit")) {
                    output.close();
                    input.close();
                    socket.close();
                    break;
                }
                String response = input.readLine();
                System.out.println("From server: " + response);
            }

            scanner.close();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
