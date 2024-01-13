package exams.e2020_07_07.exercise_3;

/*
 * Esercizio 3 (8 punti)
    Il supermercato SM si `e appena dotato di un sistema di casse intelligente. Le persone in attesa formano un’unica fila, men-
    tre il sistema individua di volta in volta la cassa, tra quelle disponibili, che pu`o servire il cliente. Si modelli il suddet-
    to sistema in Java, utilizzando solo i meccanismi base della sincronizzazione di Java senza sfruttare classi e pacchetti concurrent
    Chiaramente, il tempo speso da ogni utente per le operazioni di pagamento varia di volta in
    volta: ogni cassa viene prima occupata dal cliente e poi liberata a pagamento avvenuto. Si esemplifichi anche il comportamento
    del sistema supponendo di avere 30 clienti in attesa e 10 casse a disposizione
 */

public class Supermarket {
    private int counters;
    
    public Supermarket(int counters){
        this.counters = counters;
    }    

    public synchronized boolean getCounter(){
        if(counters > 0) {counters--; return true;}
        return false;
    }

    public synchronized void releaseCounter(){counters++; notifyAll();}
}
