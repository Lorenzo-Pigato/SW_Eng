package exams.e2020_02_04.exercise_2;

/*
 * Esercizio 2 (6 punti)
    Una pasticceria ha deciso di aprire uno store online per vendere i propri panettoni. Ogni cliente può comprare al massimo 3
    panettoni per volta, ma il sistema, sperimentale, non `e in grado di servire pi`u di 5 richieste in parallelo. Inoltre, la pasticceria
    mette in vendita una quantit`a limitata di panettoni, come primo esperimento. Il sistema, quindi, può consentire all’utente
    di acquistare i panettoni richiesti, pu`o non accettare l’ordine perch`e la quantit`a richiesta `e eccessiva, ma pu`o anche rifiutare
    l’ordine perch`e i panettoni rimasti non sono sufficienti. Se i panettoni rimasti sono meno di quelli richiesti, il sistema deve
    rifiutare l’intera transizione. Si esemplifichi il funzionamento del sistema ipotizzando 50 panettoni in vendita per 30 possibili
    clienti.
 */

public class Bakery {
    private int stock = 50;
    private int requests = 0;

    public synchronized int request(int amount){
        if(this.requests + amount <= 5 && this.stock >= amount){ requests += amount; stock -= amount; return 1; }
        else if(this.stock <= 0) {return -1;}
        return 0;
    }

    public synchronized void exit(int amount){
        requests -= amount;
        notifyAll();
    }
}
