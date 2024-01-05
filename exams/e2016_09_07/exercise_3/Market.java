package exams.e2016_09_07.exercise_3;
/*
Esercizio 3 (7 punti)
Si vuole realizzare un sistema per la gestione delle attività commerciali relative ad una società che gestisce il mercato dei
lingotti d’oro. 

Il mercato ha una capacità massima di M lingotti e può gestire non più di N utenti contemporaneamente. Gli
utenti possono essere acquirenti oppure venditori, con ruoli diversi e ovvi. Ogni utente può acquistare/vendere lingotti in
numero finito, ma ovviamente non si possono comprare più lingotti di quanti disponibili in quel momento e non è possibile
violare il limite di M lingotti acquisiti dalla società di gestione. Per semplicità si supponga che il prezzo di acquisto/vendita di
un lingotto sia sempre uguale.
Si scriva quindi un programma Java concorrente che realizzi il sistema di controllo sopra descritto.
 */

public class Market {
    private int capacity;
    private int activity;

    public Market(int capacity, int max_users){
        this.capacity = capacity;

        for(int i = 0; i < max_users; i++){
            new Thread(new User(i, (Math.random()*2) < 1 ? false : true, this)).start();
        }
    }

    public synchronized boolean canSell(int amount){
        if (amount < capacity - activity) {
            activity += amount;
            return true;
        }
        else{
            System.out.println("Market at full capacity");
            return false;
        }
    }

    public synchronized boolean canBuy(int amount){
        if (amount < activity) {
            activity -= amount;
            notifyAll();
            return true;
        }
        else
        {
            System.out.println("---- Not enough gold ----");
            return false;
        }
    }

    public int getCapacity() {
        return capacity;
    }

    public static void main(String[] args) {
        new Market(100, 250);
    }

}
