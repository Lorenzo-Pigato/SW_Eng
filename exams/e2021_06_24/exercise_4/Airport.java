package exams.e2021_06_24.exercise_4;

import java.util.ArrayList;

/*
 * Esercizio 4 (4 punti)
    Si modelli il sistema di smistamento bagagli di un aeroporto. Ogni aeroporto `e dotato di un numero n di nastri per la consegna
    bagagli e ogni nastro pu`o gestire al pi`u tre voli e b bagagli contemporaneamente. Questo significa che il sistema deve indirizzare
    i diversi bagagli al nastro di pertinenza e deve controllare che questo non contenga mai troppi bagagli, per evitare che il
    sistema si fermi. Si applichino poi le classi definite ad un aeroporto con 5 nastri per la consegna dei bagagli, 12 voli in
    contemporanea e 500 bagagli da smaltire, supponendo che ogni nastro non possa gestire pi`u di 20 bagagli contemporaneamente.
    Si realizzi il sistema concorrente in Java usando solo i meccanismi base della sincronizzazione, senza sfruttare classi e pacchetti
    di java.util.concurrent.XXX.
 */

public class Airport {
    private ArrayList<Conveyor> conveyors = new ArrayList<>();

    public Airport(int conveyorsQty){
        for(int i = 0; i < conveyorsQty; i++){
            this.conveyors.add(new Conveyor(i));
            new Thread(conveyors.get(i)).start();
        }
    }

    public synchronized Conveyor getConveyor(){
    
        for (Conveyor conv : conveyors) {
            if(conv.getFlights() < 3) {
                conv.set(1);
                return conv;
                
            }
        }

        return null;
    }

    public synchronized void releaseConveyor(Conveyor conveyor){
        conveyor.set(-1);
        notifyAll();
    }

    public static void main(String[] args) {
        Airport airport = new Airport(10);

        for(int i = 0; i < 30; i++){
            new Thread(new Flight(i, airport, 50)).start();
        }
    }


}

class Conveyor implements Runnable{
    private int id;
    private int flights = 0;
    private int onConv = 0;

    public Conveyor(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public synchronized boolean load(){
        if (onConv < 20) {
            onConv ++;

            return true;
        }

        return false;
    }

    public synchronized int getFlights() {
        return flights;
    }

    public synchronized void set(int i){
        flights += i;
    }

    @Override
    public void run() {
        while (true) {
            if (onConv > 0) {
                synchronized(this){
                    System.out.println("C" + id + ": " + onConv + " moving luggage");
                    onConv--;
                    this.notifyAll();
                }
            }

            try {
                    Thread.sleep(1000);
                } catch (Exception e) {return;}
        }
    }
}
