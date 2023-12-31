package Exercise.Exercise_11;

public class Producer implements Runnable {
    private String id;
    private Account account;
    private int maxAmount;

    public Producer(String id, Account account, int maxAmount){
        this.id = id;
        this.account = account;
        this.maxAmount = maxAmount;
    }

    @Override
    public void run() {
        while (true) {

            System.out.println(id + ": accessing account\n");
            
            try {
                synchronized(account)
                {
                    this.account.deposit((int)(Math.random() * maxAmount));
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }

            System.out.println();

        }
    }
}
