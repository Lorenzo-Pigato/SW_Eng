package Exercise.Exercise_8;

/*
    
    👉  Deﬁnire Person and Product che estendono Entity. Person ha attributi nome e
        cognome, mentre Product ha attributi nome e prezzo. Fare override del
        metodo displayDetails( ).

 */

public class Product extends Entity {
    private String name;
    private double price;
    
    public Product (String id, String name, double price){
        this.name = name;
        this.price = price;

        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public double getPrice() {
        return price;
    }

    @Override
    void displayDetails() {
        System.out.println(name + ": " + price + "$");
    }
}
