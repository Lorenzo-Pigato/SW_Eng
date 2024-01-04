package exams.e2016_07_20.exercise_2;

public abstract class Protein extends Ingredient {
    public Protein(Sandwich sandwich){
        super(sandwich);
    }
}

class Ham extends Protein {
    public Ham (Sandwich sandwich){
        super(sandwich);
    }

    @Override
    public void assembly() {
        // super.assembly() will apply superclass assembly method before new specfic asssembly
        super.assembly();
        System.out.println("adding ham");
    }
}

class Tuna extends Protein {
    public Tuna (Sandwich sandwich){
        super(sandwich);
    }

    @Override
    public void assembly() {
        // super.assembly() will apply superclass assembly method before new specfic asssembly
        super.assembly();
        System.out.println("adding tuna");
    }
}