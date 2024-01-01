package Exercise.Exercise_14;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
    Esercizio 2 / Parrot Server
    Implementare un client server TCP.
    
    👉 Il server e’ in ascolto su una porta.
    
    👉 Il client si connette al server.
    
    👉 L’utente può’ inserire testo dal terminale client, e il client lo spedira’ al server.
    
    👉 Il server risponde con lo stesso messaggio ricevuto dal client.
    
    👉 Se l’utente digita “exit”, il client si disconnette.
 */

public class ParrotServer {
    static ServerSocket serverSocket;
    public static void main(String[] args) {
        try {
            serverSocket = new ServerSocket(12345);
            while (true) {
                Socket client = serverSocket.accept();
                // Anonymous Thread for client handling:
                new Thread(new Handler(client)).start();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Handler implements Runnable {
    private Socket client;
    private PrintWriter output;
    private BufferedReader input;
    
    public Handler(Socket socket) {
        this.client = socket;
        try {
            // PrintWriter is a formatted type of output stream
            this.output = new PrintWriter(client.getOutputStream());
            this.input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void run() {
        String message = new String();
        while (!message.equals("exit")) {
            try {
                message = input.readLine();
                output.println(message);
                output.flush();

                System.out.println("Received: " + message);
            } catch (Exception e) {
               System.out.println(e.getMessage()); 
            }
        }
    }
}
