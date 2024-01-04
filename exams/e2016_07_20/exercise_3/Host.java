package exams.e2016_07_20.exercise_3;

public class Host implements Runnable {
    private String id;
    private Pool pool;
    private boolean isPatient;

    public Host(String id, Pool pool, boolean isPatient) {
        this.id = (isPatient ? "P" : "H") + id;
        this.pool = pool;
        this.isPatient = isPatient;
    }

    private void suspend(int millis) {
        try {
            Thread.sleep((int)(Math.random() * 3000 + millis));
        } catch (Exception e) {
            System.out.println("Error pausing thread");
        }
    }

    @Override
    public void run() {

        this.suspend(isPatient ? (int)(Math.random() * 10000) : 0);

        synchronized (pool) {
            while (!pool.isAvailable(isPatient)) {
                try {
                    pool.wait();
                } catch (Exception e) {
                    System.out.println("Error waiting resource");
                }
            }
        }

        System.out.println((isPatient ? "Patient " : "Host ") + id + " is entering pool");

        this.suspend(0);

        synchronized(pool){
            System.out.println((isPatient ? "Patient " : "Host ") + id + " is leaving pool");
            pool.leavePool(isPatient);
        }
    }
}