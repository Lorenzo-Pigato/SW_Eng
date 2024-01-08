package exams.e2022_08_29.exercise_3;

public class Doub implements CounterState{
    private Counter counter;
    
    public Doub (Counter counter){
        this.counter = counter;
    }
    
    @Override
    public void incrementCounter() {
        this.counter.count += 2;
    }
}
