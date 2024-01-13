package exams.e2020_02_04.exercise_1;

/*
 * @ public invariant (waste != null) && (volume > 0) &&
 * @ level >= 0 && level <= volume;
 */

 @SuppressWarnings("unused")

public class Trashbin {
    private Waste waste;
    private double volume;
    private double level;

    public Trashbin(Waste waste, double volume){
        this.waste = waste;
        this.volume = volume;
    }

    public Waste getWaste() {
        return waste;
    }

    /* 
     * @ assignable level;
     * @ requires waste != null;
     * @ ensures (levels == \old.level + waste.getSize) <==> (waste.getType() == this.waste.getType()) && (waste.getVolume <= this.volume - this.level)
     * @ signals (WrongTypeException wte) waste.getType() != this.waste.getType();
     * @ signals (NotEnoughSpaceExcetion nese) waste.getVolume() > this.volume - this.level;
     */
    public void throwWaste(Waste waste){
        if(waste.getType().equals(this.waste.getType()))
            if(level + waste.getVolume() <= level) 
                this.volume+=waste.getVolume();
            else
                System.out.println("Not enough space"); 
        else System.out.println("Wrong wasted type");
    }

}
