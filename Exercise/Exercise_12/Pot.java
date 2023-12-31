package Exercise.Exercise_12;

public class Pot {
    private int portions;

    public synchronized void getPart(Camper camper) {
        System.out.println("Camper " + camper.name + " get one part");
        this.portions--;

        if (this.portions == 0) {
            notifyAll();
        }
    }

    public synchronized void fill(int amount) {
        System.out.println("Chef filled " + amount + " portions");
        this.portions += amount;

        notifyAll();
    }

    public int getPortions() {
        return portions;
    }

    public static void main(String[] args) {
        Pot pot = new Pot();
        Chef chef = new Chef(pot);
        Camper c1 = new Camper(pot, "Jack");
        Camper c2 = new Camper(pot, "Joe");
        Camper c3 = new Camper(pot, "Moe");
        Camper c4 = new Camper(pot, "Tom");

        new Thread(chef).start();
        new Thread(c1).start();
        new Thread(c2).start();
        new Thread(c3).start();
        new Thread(c4).start();
    }
}
