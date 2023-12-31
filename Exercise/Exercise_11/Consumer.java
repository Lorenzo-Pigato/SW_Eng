package Exercise.Exercise_11;

public class Consumer implements Runnable {
    private String id;
    private Account account;
    private int maxAmount;
    private int cooldown;
    
    public Consumer(String id, Account account, int maxAmount, int cooldown){
        this.id = id;
        this.account = account;
        this.maxAmount = maxAmount;
        this.cooldown = cooldown;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(id + ": accessing account");

            try {
                synchronized (account) {
                    this.account.take((int) (Math.random() * maxAmount));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                Thread.sleep(cooldown);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println();
            
        }
    }
}
