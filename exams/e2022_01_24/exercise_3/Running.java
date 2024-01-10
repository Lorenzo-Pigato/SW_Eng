package exams.e2022_01_24.exercise_3;

public class Running implements ChronoState {
    private Chrono chrono;

    public Running(Chrono chrono) {
        this.chrono = chrono;
    }

    @Override
    public void clickStart() {
        System.out.println("Starting");
        chrono.start();
    }

    @Override
    public void clickStop() {
        System.out.println("Pausing");
        this.chrono.stop();
        System.out.println(chrono.getSeconds());
        chrono.setState(new Paused(chrono));
    }
}
