package Exercise.Exercise_6;

public class InsufficientFundsException extends Exception{
    private String message;
    private double amount;
    private double balance;

    public InsufficientFundsException (double amount, double balance){
        this.amount = amount;

        this.message =  "Impossible to whitdraw " + amount + "$\nAvailable balance is: " + balance + "$";
    }

    @Override
    public String getMessage() {
        return message;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalance() {
        return balance;
    }
}