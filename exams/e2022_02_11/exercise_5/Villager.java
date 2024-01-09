package exams.e2022_02_11.exercise_5;

public class Villager implements Runnable {
    private Tank bigTank;
    private String id;
    private Object tapLock;

    public Villager(String id, Tank biTank, Object tapLock) {
        this.id = id;
        this.bigTank = biTank;
        this.tapLock = tapLock;
    }

    @Override
    public void run() {
        synchronized (tapLock) {
            while (!bigTank.getTap()) {
                try {
                    tapLock.wait();
                } catch (Exception e) {
                    System.out.println("Error");
                    return;
                }
            }

            System.out.println(id + " got a tap");
        }

        for (int i = (int) (Math.random() * 4 + 1); i > 0; i--) {
            synchronized (bigTank) {
                if (!bigTank.fillMyTank()) {
                    i++;
                    System.out.println("Water is over");

                    try {
                        bigTank.wait();
                    } catch (Exception e) {
                        System.out.println("Error");
                        return;
                    }
                } else
                    System.out.println(id + " filled a tank");
            }

        }

        synchronized (tapLock) {
            System.out.println(id + " releasing tap");
            bigTank.releaseTap();
        }
    }
}

class Major implements Runnable {
    private Tank bigTank;

    public Major(Tank biTank) {
        this.bigTank = biTank;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (bigTank) {
                try {
                    bigTank.wait();
                } catch (Exception e) {
                    System.out.println("Error");
                    return;
                }
                System.out.println("Tank refilled");
                bigTank.refillTank();
            }
        }
    }
}
