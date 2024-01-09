package exams.e2022_02_11.exercise_5;

public class Tank {
    private int reservoire = 1000;
    private int taps = 10;

    public Object tapLock = new Object();

    public boolean getTap(){
        synchronized (tapLock)
        {
            if (taps > 0) {
                taps--;
                return true;
            }
    
            return false;       
        }
    }

    public void releaseTap(){
        synchronized (tapLock)
        {
            taps++;
            tapLock.notifyAll();      
        }
    }

    public synchronized boolean fillMyTank() {
        if(reservoire > 0){
            this.reservoire-=1;
            return true;
        }

        notifyAll();
        return false;
    }

    public synchronized void refillTank() {
        reservoire = 1000;
        notifyAll();
    }

    public static void main(String[] args) {
        Tank tank = new Tank();
        
        new Thread(new  Major(tank)).start();

        for(int i = 0; i < 2000; i++){
            new Thread(new Villager(String.valueOf(i), tank, tank.tapLock)).start();
        }
    }

}
