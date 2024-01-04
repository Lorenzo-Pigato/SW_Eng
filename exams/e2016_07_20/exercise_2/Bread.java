package exams.e2016_07_20.exercise_2;

public abstract class Bread extends Ingredient {
    public Bread(Sandwich sandwich){
        super(sandwich);
    }
}

class WhiteBreat extends Bread {
    public WhiteBreat (Sandwich sandwich){
        super(sandwich);
    }

    @Override
    public void assembly() {
        // super.assembly() will apply superclass assembly method before new specfic asssembly
        super.assembly();
        System.out.println("Using white bread as base");
    }
}

class CerealBread extends Bread {
    public CerealBread (Sandwich sandwich){
        super(sandwich);
    }
    
    @Override
    public void assembly() {
        // super.assembly() will apply superclass assembly method before new specfic asssembly
        super.assembly();
        System.out.println("Using cereal bread as base");
    }
}

class ArabicBread extends Bread {
    public ArabicBread (Sandwich sandwich){
        super(sandwich);
    }
    
    @Override
    public void assembly() {
        // super.assembly() will apply superclass assembly method before new specfic asssembly
        super.assembly();
        System.out.println("Using arabic bread as base");
    }
}