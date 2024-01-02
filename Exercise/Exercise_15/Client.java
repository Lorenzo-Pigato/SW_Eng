package Exercise.Exercise_15;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/*
    Esercizio 3 / Parrot Server+
    Estendere Parrot Server

    👉  Rendere non bloccante il server utilizzando i thread.
    
    👉  Collegare diversi client al server e veriﬁcare il corretto funzionamento del server.

    👉  Implementare un protocollo per gestire quattro tipi di messaggio:
        - Login Message: Il client invia il proprio nome utente.
        - Text Message: Il server risponde con il nome utente del mittente e il contenuto del
          messaggio ricevuto.
        - Reversed Message: Il server risponde con il nome utente del mittente e il contenuto
          al contrario del messaggio ricevuto.
        -  Exit Message: Il server disconnette il client.
 */

public class Client {
    public static void main(String[] args) {
        String clientId;
        Socket socket;
        PrintWriter sender;
        BufferedReader receiver;
        Scanner input;

        try {
            input = new Scanner(System.in);
            
            System.out.print("Insert server IP:PORT - ");
            String[] address = input.nextLine().split(":");
            
            socket = new Socket(address[0], Integer.parseInt(address[1]));
            System.out.println("Socket connected to server: " + socket.getInetAddress() + " on port: " + socket.getPort());

            receiver = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            sender = new PrintWriter(socket.getOutputStream());

            System.out.print("login: ");
            clientId = input.nextLine();
            sender.println(clientId);
            sender.flush();
            System.out.println(receiver.readLine());

            System.out.println("Write 'R:message' to get reverse from server, 'exit' to quit");
            String message = new String();
            
            while (message != "exit") {
                System.out.print(clientId + ": ");
                message = (input.nextLine());

                sender.println(message);
                sender.flush();
        
                if (message.equals("exit")) {
                    sender.println(message);
                    sender.flush();
                    
                    sender.close();
                    receiver.close();
                    input.close();
                    socket.close();
                    break;
                }
                
                System.out.println("From server: " + receiver.readLine());
            }
        } catch (Exception e) {
            System.out.println("Connection to the server can't be established");
        }

    }
}
