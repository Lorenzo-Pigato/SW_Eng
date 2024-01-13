package exams.e2020_02_04.exercise_2;

public class Client implements Runnable {
    private Bakery b;
    private int id;

    public Client(int id, Bakery b) {
        this.b = b;
        this.id = id;
    }

    @Override
    public void run() {
        int res = 0;
        int amount = (int)(Math.random()*3+1);
        synchronized(b){
            while ((res = b.request(amount)) == 0) {
                try {b.wait();} 
                catch (Exception e) {};
            }
        }

        if(res == -1) return;

        System.out.println(id + " ordered " + amount);

        try {Thread.sleep((int)Math.random() * 5000);} 
        catch (Exception e) {};

        System.out.println(id + " is leaving the counter");

        synchronized (b) {b.exit(amount);}
    }    

}

