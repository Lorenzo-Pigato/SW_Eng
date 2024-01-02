package Exercise.Exercise_15;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ParrotExtServer {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.print("Welcome to ParrotServer - Extended\nInsert port number to start the service: ");
        int portAddress = Integer.parseInt(input.nextLine());
        input.close();
        
        try {
            ServerSocket serverSocket = new ServerSocket(portAddress);
            System.out.println("Server is up and running on port: " + portAddress);
            while (true) {
                Socket client = serverSocket.accept();
                
                new Thread(new Handler(client)).start();
            }
        } catch (Exception e) {
            System.out.println("Server can't be started");
        }
    }
}