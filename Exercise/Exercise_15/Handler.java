package Exercise.Exercise_15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Handler implements Runnable {
    private BufferedReader receiver;
    private PrintWriter sender;
    private String clientId;

    public Handler(Socket client){
        try {
            System.out.println("New connection request received from: " + client.getInetAddress());
            receiver = new BufferedReader(new InputStreamReader(client.getInputStream()));
            sender = new PrintWriter(client.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        String message = new String();

        try{
            this.clientId = receiver.readLine();
        } catch (Exception e) {
            System.out.println("Error reading client ID");
        }
        
        System.out.println("Client " + "connected");
        sender.println("logged in");
        sender.flush();

        while (!message.equals("exit")) {
            try {
                message = receiver.readLine();

                if(message.startsWith("R:"))
                    sender.println(new StringBuilder(message.split(":")[1]).reverse().toString());
                else
                    sender.println(message);
                
                sender.flush();

                System.out.println(clientId + ": " + message);
            } catch (Exception e) {
               System.out.println("Generic error on client: " + this.clientId); 
            }
        }

        try {
            System.out.println("Client " + clientId + " closed the session");
            receiver.close();
            sender.close();
        } catch (Exception e) {
            System.out.println("Error closing IO Streams");
        }
    }
}
