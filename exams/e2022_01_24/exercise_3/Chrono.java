package exams.e2022_01_24.exercise_3;

public class Chrono {
    private ChronoState state;
    private double seconds;
    private Thread runner = null;

    public Chrono() {
        this.state = new Running(this);
        this.seconds = 0;
    }

    public double getSeconds() {
        return seconds;
    }

    public void clickStart() {
        this.state.clickStart();
    }

    public void clickStop() {
        this.state.clickStop();
    }

    public void setState(ChronoState state) {
        this.state = state;
    }

    public void reset() {
        this.seconds = 0;
    }

    public void start() {
        this.runner = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                    seconds++;
                    System.out.println(seconds);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            }
        });

        runner.start();
    }

    public void stop() {
        if (runner != null) {
            this.runner.interrupt();
        }
    }

    public static void main(String[] args) {
        Chrono myChrono = new Chrono();
        
        System.out.println("Starting chrono in 3 secs");
         try {
            Thread.sleep(3000);
        } catch (Exception e) {System.out.println("Main error");}

        myChrono.clickStart();
        
        try {
            Thread.sleep(10000);
        } catch (Exception e) {System.out.println("Main error");}

        myChrono.clickStop();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {System.out.println("Main error");}

        myChrono.clickStart();

        try {
            Thread.sleep(5000);
        } catch (Exception e) {System.out.println("Main error");}

        myChrono.clickStop();
        myChrono.clickStop();
    }
}
