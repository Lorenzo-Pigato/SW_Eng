package exams.e2016_07_20.exercise_2;

public abstract class Others extends Ingredient {
    public Others(Sandwich sandwich){
        super(sandwich);
    }
}

class Mozzarella extends Others {
    public Mozzarella (Sandwich sandwich){
        super(sandwich);
    }

    @Override
    public void assembly() {
        // super.assembly() will apply superclass assembly method before new specfic asssembly
        super.assembly();
        System.out.println("adding mozzarella");
    }
}

class Tomatoes extends Others {
    public Tomatoes (Sandwich sandwich){
        super(sandwich);
    }

    @Override
    public void assembly() {
        // super.assembly() will apply superclass assembly method before new specfic asssembly
        super.assembly();
        System.out.println("adding tomatoes");
    }
}