package exams.e2020_01_14.exercise_2;

/*
 * Esercizio 2 (6 punti)
    Un gruppo di 1500 persone vorrebbe comprare i biglietti per il concerto di LP. Al botteghino sono a disposizione solo 500
    biglietti e vi sono solo 5 persone che li vendono. Questo significa che solo 5 persone alla volta potranno comprare i biglietti
    e solo se ve ne fossero ancora a disposizione. Ogni persona impegna un tempo variabile (casuale) per comprare un biglietto e
    pu`o comprare fino ad un massimo di 3 biglietti. Ogni persona, quindi, prova a comprare i biglietti richiesti, aspetta, se tutti i
    venditori sono occupati, e, appena possibile, conclude l’acquisto, se i biglietti rimasti sono sufficienti. Se i biglietti disponibili
    fossero in numero inferiore a quelli richiesti, la persona comprerebbe comunque tutti i biglietti disponibili. Se non ci fossero
    pi`u biglietti disponibili, la persona simplecemente lascerebbe il sistema
 */

public class Seller {
    private int stock = 500;
    private int requests = 0;

    public synchronized int request(int amount){
        if(this.requests < 5 && this.stock >= amount){ requests ++; stock -= amount; return 1; }
        else if(this.stock <= 0) {return -1;}
        return 0;
    }

    public synchronized void exit(int amount){
        requests --;
        notifyAll();
    }

    public static void main(String[] args) {
        Seller sell = new Seller();
        
        for(int i = 0; i < 1500; i++)
            new Thread(new Fan(i, sell)).start();
        
    }
}
