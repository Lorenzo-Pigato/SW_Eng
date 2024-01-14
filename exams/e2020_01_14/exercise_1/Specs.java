package exams.e2020_01_14.exercise_1;

import java.util.ArrayList;

/*
    Esercizio 1 (9 punti)
        Si pensi a due classi Java che implementano i concetti di MazzoDiCarte e Carta, considerando un mazzo da 54 carte ed i
        soliti 4 semi: 13 carte per seme pi`u due jolly. Ogni carta `e definita dal seme e dal valore (da 1 a 10, fante, cavallo e re); ogni
        mazzo contiene 52 carte ed ha un colore. A fronte di queste informazioni:
        • Si definisca una rappresentazione (plausibile) per le due classi in Java.
        • Si definiscano gli invarianti privati delle due classi in JML.
        • Si definisca la specifica JML del metodo mescola della classe Mazzo, che mescola ”virtualmente” il mazzo di carte,
        con il vincolo che almeno il 50% delle carte del mazzo sia in una posizione diversa. Si definiscano eventuali metodi pure,
        se necessario.
*/

public class Specs {
    
}

/*
 * @ private invariant cards != null && cards.size() == 54 &&
 * @                           (\forall int i; i >= 0 && i < cards.size();
 * @                             !(\exists int j; j >= 0 && j < cards.size() && i != j; cards.get(i).equals(cards.get(j)));
 * @ private invariant color != null && (\forall Deck d1; d1 != null; 
 *                                          !(\exists Deck d2; d2 != null && !(d2.equals(d1)); 
 *                                              d1.getColor().equals(d2.getColor())));
 */
class Deck{
    private ArrayList<Card> cards;
    private String color;

    public ArrayList<Card> getCards() {
        return cards;
    }

    public String getColor() {
        return color;
    }

    public void addCard(Card c) {}

    /*
     * @ requires true
     * @ ensures (\forall int i; i >= 0 && i < cards.size(); 
     * @            (\num_of int j; j >= 0 && j < cards.size(); 
     * @                cards.get(i).equals(\old.cards.get(j))) < card.size()/2) ------> (*More than half of the cards are in a different position*)
     * @            && (\forall Cards c; \old.cards.contains(c); 
     * @                    (\exists i; i >= 0 && i <= cards.size(); cards.get(i).equals(c))); -------> (*All old cards are present inside the shuffled deck*)   
     */
    public void shuffle(){}
}

/*
 * @ private invariant value != null && ((\exists int i; i > 1 && i <= 10; value.equals(String.valueOf(i))) || value.equals("A") 
 * @                                                                                                        || value.equals("J") 
 * @                                                                                                        || value.equals("Q") 
 * @                                                                                                        || value.equals("K"));
 * @ private invariant suit != null && (suit.equals("Hearts") 
 * @                                    || suit.equals("Diamons") 
 * @                                    || suit.equals("Clubs") 
 * @                                    || suit.equals("Spades"));
 */
class Card {
    private String value;
    private String suit;

    public Card(String value, String suit){
        this.value = value;
        this.suit = suit;
    }

    public /*@ pure @*/ String getSuit() {
        return suit;
    }

    public /*@ pure @*/ String getValue() {
        return value;
    }

    @Override
    public /*@ pure @*/ boolean equals(Object c) {
        if(c instanceof Card){
            if(value.equals(((Card)c).getValue()) && suit.equals(((Card)c).getSuit())) return true;
            return false;
        }

        return false;
    }
}
