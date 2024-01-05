package exams.e2016_09_07.exercise_1;

import java.time.LocalDate;
import java.util.ArrayList;

/*

Esercizio 1 (10 punti)

Si vuole realizzare il software di gestione di un registratore di cassa per emettere scontrini fiscali e memorizzarli in modo
appropriato. 

Per semplicità, si ipotizzi di usare una valuta senza centesimi e quindi rappresentabile solo con numeri interi. 

Ogni scontrino riporta un ammontare, la data di emissione e il numero dello scontrino nel corso della giornata (chiaramente, il primo
scontrino della giornata ha numero 1).



Il registratore di cassa memorizza gli scontrini di un intero anno, organizzandoli per
settimana (da 1 a 52) e per mese (da 1 a 12).

La classe Registratore fornisce, tra gli altri, i seguenti metodi:
• void emettiScontrino(int imp) per l’emissione di uno scontrino di importo imp. Chiaramente, la data è
quella corrente e il numero dello scontrino viene incrementato in modo opportuno.

• void cancellaScontrino () per cancellare l’ultimo scontrino emesso.

• ArrayList<Scontrino>scontrini() per avere la lista degli scontrini emessi fino a quel momento nel corso
della giornata.

La classe Scontrino fornisce semplicemente tre metodi int ammontare(), Data data() e int numero() per
poter leggere i valori dei tre attributi.
Si definisca quindi:

1. Una rappresentazione appropriata per la classe Registratore;
2. La specifica JML dei metodi emttiScontrino e cancellaScontrino;
3. L’invariante di rappresentazione (in JML) della classe Registratore, considerando le scelte fatte al punto 1.

 */

/*
    @ invariant this.months[] != null && this.weeks != null;
 */
public class CashRegister {
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
