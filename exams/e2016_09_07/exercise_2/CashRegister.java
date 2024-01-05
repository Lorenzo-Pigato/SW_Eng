package exams.e2016_09_07.exercise_2;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;

/*

EEsercizio 2 (6 punti)
Considerando la classe Registratore definita all’esercizio precedente, scrivere tutto quello che serve per avere due Iteratori
che consentano di accedere, in successione, a tutti gli scontrini emessi in un singolo giorno o in una settimana. */


/*
    @ invariant this.months[] != null && this.weeks != null;
 */
public class CashRegister implements Iterable<Receipt>{
    ArrayList<ArrayList<Receipt>> [] months;
    ArrayList<ArrayList<Receipt>> [] weeks;
    ArrayList<Receipt> today;
    
    @SuppressWarnings("unchecked")
    public CashRegister() {
        this.months = new ArrayList[12];
        this.weeks = new ArrayList[54];
        this.today = new ArrayList<Receipt>();
    }

    /*
        @ requires amount>o && today != null;
        @ ensures today.size() == \old.today.size()+1;
     */
    public void addReceipt(int amount){
        today.add(new Receipt(amount, today.size()+1));
    }

    /*
        @ requires today.size() > 0 && today != null;
        @ ensures today.size() == \old.today.size()-1;
     */
    public void removeReceipt (){
        today.remove(today.size()-1);
    }

    public void stashReceipts(){
        months[LocalDate.now().getMonthValue()-1].add(today);
        weeks[(LocalDate.now().getDayOfYear()-1)/4].add(today);
    }

    public Iterator<Receipt> iterator(){
        return new Iterator<Receipt>() {
            private int index = 0;
            
            @Override
            public boolean hasNext() {
                return index < today.size();
            }

            @Override
            public Receipt next() {    
                return today.get(index);
            }
        };
    }
}

class Receipt {
    private int id;
    private int amount;
    private LocalDate date;

    public Receipt(int amount, int id){
        this.amount = amount;
        this.date = LocalDate.now();

        this.id = id;
    }

    public int getId() {
        return id;
    }
    
    public int getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}
