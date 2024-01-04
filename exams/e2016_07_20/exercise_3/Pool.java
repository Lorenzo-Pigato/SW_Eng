package exams.e2016_07_20.exercise_3;

/*
Esercizio 3 (7 punti)

Si consideri un centro termale. L’acqua della piscina ha proprietà terapeutiche e pertanto il centro è frequentato sia da normali
visitatori (visitatori) sia da persone affette da patologie (pazienti). Gli ospiti accedono singolarmente alla piscina, vi permangono 
per una quantità di tempo arbitraria e successivamente escono dalla piscina. La piscina ha una capacità massima MAXP, che
esprime il numero massimo di persone che può contenere. Il regolamento della piscina vieta la presenza contemporanea nella
piscina di visitatori e pazienti.
Si sviluppi un’applicazione concorrente in Java, che rappresenti pazienti e visitatori come thread concorrenti. L’applica-
zione deve realizzare una politica di sincronizzazione che soddisfi i vincoli dati e che, inoltre, favorisca i pazienti, rispetto ai
visitatori, nell’accesso alla piscina. Si realizzi anche un programma principale “dimostratore” che consideri almeno 50 visitatori
e 20 pazienti e una capacità massima di 60 ospiti.
 */

public class Pool {
    private int maxCapactity;

    // These indexes will work together to determine where the pool is still full or
    // booked
    private int currentActivity = 0;
    private boolean free = true;
    private boolean booked = false;

    public Pool(int maxCap, int patQty, int hostQty) {
        this.maxCapactity = maxCap;

        for (Integer i = 0; i < hostQty; i++) {
            new Thread(new Host(i.toString(), this, false)).start();
        }

        for (Integer i = 0; i < patQty; i++) {
            new Thread(new Host(i.toString(), this, true)).start();
        }
    }

    public synchronized boolean isAvailable(boolean isPatient) {
        if (isPatient) {
            if (!booked) {
                booked = true;
                free = false;
                return false;
            } 
            
            else {
                if (!free)
                    return false;

                else if (free && currentActivity < maxCapactity){
                    currentActivity++;
                    return true;
                }

                else
                    return false;
            }
        }
        
        else // isHost
        {
            if (booked)
                return false;

            else if (currentActivity < maxCapactity) {
                currentActivity++;
                return true;
            }

            else
                return false;
        }
    }

    public synchronized void leavePool(boolean isPatient) {
        currentActivity--;

        if (currentActivity == 0) {
            if (isPatient)
                booked = false;

            System.out.println("------ FREE ------");
            free = true;
        }

        notifyAll();

    }
}

class Main {
    public static void main(String[] args) {
        new Pool(5, 10, 30);
    }
}