package exams.e2016_07_06.exercise_1;

import java.util.ArrayList;

/*
    Ogni lotto è caratterizzato da un nome, una base d’asta, un rialzo minimo e un’ultima offerta. 
    La casa d’aste vuole anche memorizzare le offerte ricevute per ogni lotto.

    La classe Lotto mette, quindi a disposizione i seguenti metodi:
•   void offerta(int v) throws OffertaException consente ai diversi clienti di presentare le loro offerte.
    La prima offerta deve essere maggiore o uguale alla base d’asta e le successive devono sempre aggiungere almeno il
    rialzo minimo all’offerta precedente. Il metodo solleva l’eccezione OffertaException se l’offerta (v) non rispetta i
    vincoli elencati in precedenza.
•   int baseDAsta() e int rialzoMinimo() restituiscono la base d’asta e il rialzo minimo, rispettivamente.
•   ArrayList<Integer> offerte() fornisce le offerte fatte fino a quel momento per il lotto.
•   boolean chiusura() consente di chiudere l’asta per il lotto. L’esito è positivo (true) se è stata presentata almeno
    un’offerta maggiore o uguale alla base d’asta. Sarà negativo (false) in caso contrario.

 */

 public class Batch {
    private String name;
    private double priceTag;
    private double minBid;
    private Bid lastBid = null;
    private ArrayList<Bid> bids;
    private boolean isOpen = true;
    
    public Batch(String name, double priceTag, double minBid){
        this.minBid = minBid;
        this.priceTag = priceTag;
        this.name = name;
    }

    public void addBid(Bid newBid) throws Bid.BidException {
        if(((newBid.getPrice() > lastBid.getPrice() && newBid.getPrice() - lastBid.getPrice() >= minBid )
        || (lastBid == null && newBid.getPrice() >= priceTag)) && this.isOpen)
        {
            this.bids.add(newBid);
            this.lastBid = newBid;
        }
        else
            throw new Bid.BidException();
    }

    public double getPriceTag() {
        return priceTag;
    }

    public String getName() {
        return name;
    }

    public double getMinBid() {
        return minBid;
    }

    public boolean close(){
        if(this.lastBid != null)
        {
            this.isOpen = false;
            return true;
        }
        return false;
    }
    
}

class Bid {
    private double price;
    private String id;
    private String bidderName;

    public Bid (String id, String bidderName, double price){
        this.id = id;
        this.bidderName = bidderName;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void display(){
        System.out.println("bidder: " + bidderName + ", price: " + price + "$");
    }

    static class BidException extends RuntimeException{
        @Override
        public String getMessage() {
            System.out.println("Bid is invalid");
            return super.getMessage();
        }
    }
}