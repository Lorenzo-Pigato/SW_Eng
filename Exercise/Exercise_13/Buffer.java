package Exercise.Exercise_13;

/*
Esercizio 1 / IO Buﬀer

    👉  Dato un sistema con quattro buﬀer di caratteri.
    
    👉  Il modulo PI esegue ripetutamente le seguenti operazioni: legge da tastiera
        una coppia di valori , dove i è un numero tra 0 e 3, ch un carattere, e inserisce
        il carattere ch nel buﬀer i (ognuno dei quattro buﬀer contiene al più un
        carattere).
    
    👉  Il modulo PO considera a turno in modo circolare i quattro buﬀer e preleva il
        carattere in esso contenuto, scrivendo in uscita la coppia di valori se ha
        appena prelevato il carattere ch dal buﬀer i.
    
    👉  L’accesso a ognuno dei buﬀer è in mutua esclusione.
    
    👉  PI rimane bloccato se il buﬀer a cui accede è pieno, PO se è vuoto.
 */

public class Buffer {
    private int id;
    private char buffered;
    private boolean empty;

    public Buffer(int id){
        this.id = id;
        this.empty = true;
    }

    public synchronized char read(){
        while (empty) {
            try {
                this.wait();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        this.empty = true;
        notifyAll();
        return this.buffered;
    }

    public synchronized void fill(char c){
        while (!empty) {
            try {
                this.wait();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        this.empty = false;
        this.buffered = c;
        notifyAll();
    }

    public int getId() {
        return id;
    }

}
