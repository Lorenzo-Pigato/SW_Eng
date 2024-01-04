package exams.e2016_07_20.exercise_2;

public abstract class Ingredient implements Sandwich{
    protected Sandwich sandwich;

    public Ingredient(Sandwich sandwich){
        this.sandwich = sandwich;
    }

    @Override
    public void assembly() {
        // this calls basic model assembly method
        this.sandwich.assembly();
    }
}