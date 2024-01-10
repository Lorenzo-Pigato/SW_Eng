package exams.e2021_09_09.exercise_4;

public class Element implements Runnable {
    private int id;
    private Factory factory;

    public Element(int id, Factory factory) {
        this.id = id;
        this.factory = factory;
    }

    @Override
    public void run() {
        int line = -1;
        synchronized (factory) {
            while ((line = factory.getLine() ) < 0) {
                try {
                    factory.wait();
                } catch (Exception e) {System.out.println("Error");}
            }
        }

        System.out.println("Producing: " + id + " On line: " + line);
        try {
            Thread.sleep((int)(Math.random()*1000));
        } catch (Exception e) {System.out.println("Error");}

        System.out.println("production completed on line: " + line);

        factory.releaseLine(line);
        

    }
}
