package exams.e2020_06_12.exercise_2;

public class Tourist implements Runnable{
    private  Louvre louvre;
    private int id;

    public Tourist (int id, Louvre louvre) {
        this.louvre = louvre;
        this.id = id;
    }

    @Override
    public void run() {
        synchronized(louvre){
            while (louvre.request() == false) {
                try {louvre.wait();} 
                catch (Exception e) {};
            }
        }

        System.out.println(id + " is watching the Monna Lisa");

        try {Thread.sleep((int)Math.random() * 5000);} 
        catch (Exception e) {};

        System.out.println(id + " is leaving the room");

        synchronized (louvre) {louvre.exit();}
    }    

}
