package exams.e2022_08_29.exercise_3;

public class Single implements CounterState {
    private Counter counter;

    public Single(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void incrementCounter() {
        this.counter.count += 1;
    }
}
