package exams.e2022_06_24.exercise_5;

import exams.e2022_06_24.exercise_3.FormattedText;

public class Consumer implements Runnable {
    private Buffer buffer;
    private String id;
    private Object lock;

    public Consumer(String id, Buffer buffer, Object lock) {
        this.id = id;
        this.buffer = buffer;
        this.lock = lock;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (Exception e) {
                    System.out.println(FormattedText.apply(FormattedText.apply("Error in consumer lock", "bold"), "red"));
                }

                try {
                    Thread.sleep(700);
                } catch (Exception e) {System.out.println("Sleep error");}

                System.out.println(FormattedText.apply(id + " - " + this.buffer.read(), "green"));
            }
        }
    }
}

class Filler implements Runnable {
    Buffer buffer;
    Object lock;

    public Filler(Buffer buffer, Object lock) {
        this.buffer = buffer;
        this.lock = lock;
        buffer.fill(5);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                try {
                    lock.wait();
                } catch (Exception e) {
                    System.out.println("Error in filler");
                }

                try {
                    Thread.sleep(1000);
                } catch (Exception e) {System.out.println("Sleep error");}


                buffer.fill((int) (Math.random() * 10));
                System.out.println(FormattedText.apply("Buffer filled", "yellow"));
            }
        }
    }
}