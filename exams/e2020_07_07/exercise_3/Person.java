package exams.e2020_07_07.exercise_3;

public class Person implements Runnable {
    private Supermarket sm;
    private int id;

    public Person(int id, Supermarket sm) {
        this.sm = sm;
        this.id = id;
    }

    @Override
    public void run() {
        synchronized(sm){
            while (!sm.getCounter()) {
                try {sm.wait();} 
                catch (Exception e) {};
            }
        }

        System.out.println(id + " arrived at the counter");

        try {Thread.sleep((int)Math.random() * 5000);} 
        catch (Exception e) {};

        System.out.println(id + " is leaving the counter");

        synchronized (sm) {sm.releaseCounter();}
    }    

}
