package Exercise.Exercise_6;

public class NegativeAmountException extends Exception {
    private String message;
    private double amount;
    
    
    public NegativeAmountException(double amount){
        this.amount = amount;

        this.message =  "Impossible to whitdraw " + amount + "$";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public double getAmount() {
        return amount;
    }
}
