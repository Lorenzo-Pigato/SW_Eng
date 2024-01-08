package exams.e2022_08_29.exercise_3;

// State design pattern

public class Counter {
    private CounterState state;
    public int count;
    
    public Counter(){
        this.count = 0;
        this.state = new Single(this);
    }

    public void press() {
        this.state.incrementCounter();
    }

    public void setSingle() {    
        this.state = new Single(this);
    }

    public void setDouble() {
        this.state = new Doub(this);
    }

    public static void main(String[] args) {
        Counter counter = new Counter();
        counter.setSingle();
        for(int i = 0; i < 10; i++) counter.press();
        counter.setDouble();
        for(int i = 0; i < 2; i++) counter.press();
        System.out.println(counter.count);
    }

}

