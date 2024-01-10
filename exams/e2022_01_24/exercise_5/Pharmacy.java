package exams.e2022_01_24.exercise_5;

/*
 * Esercizio 5 (8 punti)
    Numero di pazienti che possono essere gestiti contemporaneamente deve essere configurabile. 
    Ogni paziente prova ad entrare nella sala dei tamponi. 
    Se il display `e verde, il paziente entra e gli viene fatto il tampone
    esce ad aspettare l’esito in un’area apposita. 
    Se il display fosse rosso, il paziente deve aspettare che diventi verde
    Ricevuto l’esito, dopo un tempo variabile, l’utente lascia il sistema.
    
    Si istanzi poi il sistema considerando una farmacia
    che ha 5 postazioni nella sala tamponi e che deve gestire 20 pazienti che arrivano quasi contemporaneamente.
 */
public class Pharmacy {
    private int freeSpace;
    
    public Pharmacy (int freeSpace){
        this.freeSpace = freeSpace;
    }

    public synchronized boolean enter(){
        if(freeSpace > 0)
        {
            freeSpace--;
            return true;
        }

        return false;
    }

    public synchronized void exit(){
        freeSpace++;
        notifyAll();
    }

    public static void main(String[] args) {
        Pharmacy pha = new Pharmacy(10);

        for(int i=0; i< 50; i++){
            new Thread(new Patient(i, pha)).start();
        }
    }
}
