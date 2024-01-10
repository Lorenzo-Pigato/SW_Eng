package exams.e2022_06_24.exercise_5;

public class Buffer {
    private int bufferedInt;
    public Object lockMin = new Object();
    public Object lockMax = new Object();
    public Object lockFil = new Object();

    public void fill(int n) {
        this.bufferedInt = n;

        if (bufferedInt > 5)
            synchronized (lockMax) {
                lockMax.notifyAll();
            }
        else
            synchronized (lockMin) {
                lockMin.notifyAll();
            }
    }   

    public int read() {
        synchronized(lockFil){
            lockFil.notifyAll();
        }
        return bufferedInt;
    }

    public static void main(String[] args) {
        Buffer b = new Buffer();
        new Thread(new Consumer("LESS", b, b.lockMin)).start();
        new Thread(new Consumer("MORE", b, b.lockMax)).start();
        new Thread(new Filler(b, b.lockFil)).start();
    }

}
