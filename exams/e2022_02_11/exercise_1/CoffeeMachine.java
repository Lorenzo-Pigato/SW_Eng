package exams.e2022_02_11.exercise_1;

public class CoffeeMachine {

    // @ensures (\result==true) <==> (this.containerLevel() >= this.maxLevel)
    public void isFull(){}

    /*
     * @ requires !this.isFull();
     * @ signals (FullContainerException fce) this.isFull();
     */
    public void prepareCoffee(){}

    /*
     * @requires \old.this.containerLevel() > 0
     * @ensures this.containerLevel() == 0
     * @signals (AlreadyEmptyException aee) \old.this.containerLevel() == 0;
     */
    public void emptyContainer(){}
}
