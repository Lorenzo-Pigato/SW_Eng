package exams.e2016_07_06.exercise_1;

/*
    Ogni lotto è caratterizzato da un nome, una base d’asta, un rialzo minimo e un’ultima offerta. 
    La casa d’aste vuole anche memorizzare le offerte ricevute per ogni lotto.
 */

 public class Batch {
    private String name;
    private double priceTag;
    private double minBid;
    private Bid lastBid;
    private ArrayList<Bid> bids;
    
    
    
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

    public String getBidderName() {
        return bidderName;
    }

    public String getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}