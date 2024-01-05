package exams.e2016_09_07.exercise_3;

/*

 */
public class User implements Runnable {
    private int id;
    private boolean isSeller;
    private Market market;

    public User(int id, boolean isSeller, Market market) {
        this.isSeller = isSeller;
        this.id = id;
        this.market = market;
    }

    @Override
    public void run() {
        synchronized (market) {
            if (isSeller) {
                while (!market.canSell((int) (Math.random() * market.getCapacity()))) {
                    try {
                        System.out.println("Seller " + this.id + " couldn't sell gold");
                        market.wait();
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                }
                System.out.println("Seller " + this.id + " successfully sold gold");
            }
            else {
                while (!market.canBuy((int) (Math.random() * 200))) {
                    try {
                        System.out.println("Buyer " + this.id + " couldn't buy gold");
                        market.wait();
                    } catch (Exception e) {
                        System.out.println("Error");
                    }
                }
                System.out.println("Buyer " + this.id + " successfully bought gold");
            }
        }
    }

}
