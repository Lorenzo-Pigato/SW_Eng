package Exercise.Exercise_12;

public class Chef implements Runnable {
    private Pot pot;

    public Chef(Pot pot) {
        this.pot = pot;
        this.pot.fill((int) (Math.random() * 10 + 1));
    }

    @Override
    public void run() {
        while (true) {
            synchronized (pot) {
                try {
                    pot.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                pot.fill((int) (Math.random() * 10 + 1));
            }
        }
    }
}
