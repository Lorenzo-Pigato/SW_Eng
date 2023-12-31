package Exercise.Exercise_11;

/*
    Esercizio 3 / Multithreaded Account
    
    👉  Tre persone hanno un fondo comune. Una persona, il produttore, ha il compito
        di depositare i soldi per tutti alla ﬁne del mese ma non può spenderli mentre
        le altre due, i consumatori, posso prelevare. Il conto non può andare in rosso.
    
    👉  Si implementino in Java 3 componenti che simulino il fondo comune e gli
        accessi. Il produttore deposita max 200€ ogni 5 secondi, mentre il primo
        consumatore può prelevare max 300€ ogni secondo, mentre l’altro max 200€
        ogni tre secondi.
 */

public class Account {
    private int balance;

    public Account(int balance){
        this.balance = balance;
    }

    public synchronized void deposit(int amount){
        this.balance += amount;
        System.out.println("Deposited: " + amount + "$");
        System.out.println("Balance: " + balance + "$");
    }

    public synchronized void take(int amount){
        if(balance < amount)
            throw new RuntimeException("Insufficients funds");

        
        balance -= amount;
        System.out.println("Taken: " + amount + "$");
        System.out.println("Balance: " + balance + "$");
    }




    public static void main(String[] args) {
        Account account = new Account(5000);
        Consumer consumer1 = new Consumer("C00001", account, 200, 1000);
        Consumer consumer2 = new Consumer("C00002", account, 300, 3000);
        Producer producer = new Producer("P00001", account, 500);

        new Thread(producer).start();
        new Thread(consumer1).start();
        new Thread(consumer2).start();
    }
}
