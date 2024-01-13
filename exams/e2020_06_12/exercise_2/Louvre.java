package exams.e2020_06_12.exercise_2;

/*
 * Esercizio 2 (8 punti)
    Un gruppo di 100 turisti si recano al Louvre per vedere la Gioconda. Per motivi di sicurezza possono entrare nel museo solo 10
    persone alla volta. I turisti attendono un tempo casuale prima di decidere di entrare. Altrettanto casualmente, alcuni di loro poi
    guardano la Gioconda per 1 minuto, altri per 2 minuti ed altri ancora stufi, appena tocca a loro, lasciano la sala immediatamente.
    Simulare la suddetta situazione in Java, utilizzando solo i meccanismi base della sincronizzazione di Java senza sfruttare classi
    e pacchetti di java.util.concurrent.*
 */

public class Louvre {
    private int places = 10;

    public synchronized boolean request() {
        if (this.places > 0) {
                places--;
                return true;
            }
        return false;
    }

    public synchronized void exit() {
        places ++;
        notifyAll();
    }
}
