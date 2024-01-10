package exams.e2022_01_24.exercise_3;

public class Paused implements ChronoState {
    private Chrono chrono;

    public Paused(Chrono chrono){
        this.chrono = chrono;
    }

    @Override
    public void clickStart() {
        System.out.println("Continuing");
        chrono.start();
        chrono.setState(new Running(chrono));
    }

    @Override
    public void clickStop() {
        System.out.println("Resetting");
        chrono.reset();
        chrono.setState(new Running(chrono));
    }
}
