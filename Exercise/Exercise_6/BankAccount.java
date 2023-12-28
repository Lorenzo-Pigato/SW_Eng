package Exercise.Exercise_6;

/*
    Esercizio 3 / Exceptional Bank
    Si progetti un applicazione che simula le operazioni di una banca.
    
    👉  Deﬁnire la classe BankAccount caratterizzato da
        un identiﬁcativo id e un bilancio balance.
    
    👉  Deﬁnire i metodi withdraw(double amount) per prelevare denaro
        e deposit(double amount) per depositare denaro.
    
    👉  Deﬁnire l’eccezione NegativeAmountException se qualcuno cerca di
        prelevare e depositare quantità’ negative di denaro.
    
    👉  Deﬁnire l’eccezione InsuﬃcientFundsException se qualcuno cerca di
        prelevare più’ denaro di quanto possiede
 */

public class BankAccount {
    private String id;
    private double balance;

    public BankAccount (String id, double balance){
        this.id = id;
        this.balance = balance;
    }

    public void withdraw(double amount) throws NegativeAmountException, InsufficientFundsException {
        if (amount < 0) {
            throw new NegativeAmountException(amount);
        }

        else if (balance - amount < 0){
            throw new InsufficientFundsException(amount, balance);
        }

        else
            balance -= amount;
    }

    public double getBalance() {
        return balance;
    }

    public String getId() {
        return id;
    }

}


class Main{
    public static void main (String[] args){
        BankAccount bank = new BankAccount("0001", 1200);
        
        try {
            bank.withdraw(-10);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            bank.withdraw(1300);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        try {
            bank.withdraw(155.73);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println(bank.getBalance());
    }
}