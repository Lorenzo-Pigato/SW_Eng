package exams.e2020_01_14.exercise_2;

public class Fan implements Runnable {
    private Seller s;
    private int id;

    public Fan(int id, Seller s) {
        this.s = s;
        this.id = id;
    }

    @Override
    public void run() {
        int res = 0;
        int amount = (int)(Math.random()*3+1);
        synchronized(s){
            while ((res = s.request(amount)) == 0) {
                try {s.wait();} 
                catch (Exception e) {};
            }
        }

        if(res == -1) return;

        System.out.println(id + " ordered " + amount);

        try {Thread.sleep((int)(Math.random() * 2000));} 
        catch (Exception e) {};

        System.out.println(id + " is leaving");

        synchronized (s) {s.exit(amount);}
    }    

}
