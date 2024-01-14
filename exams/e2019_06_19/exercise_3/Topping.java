package exams.e2019_06_19.exercise_3;

/*
 * Esercizio 3 (5 punti)
    La catena PastaWow vuole offrire ai propri clienti un’esperienza completamente personalizzabile. Per questo motivo, i suoi
    ristoranti vendono pasta, non serve identificarne il tipo, ed un insieme di condimenti che il cliente pu`o aggiungere a piacere:
    pomodoro, pesto, funghi, piselli e panna. Anche se chiaramente un pesto con la panna potrebbe sembrare un insulto, in prima
    approssimazione non ci sono vincoli. L’app data ai camerieri deve essere in grado di calcolare automaticamente il prezzo del
    piatto ordinato, partendo dal costo della pasta e aggiungendo i condimenti selezionati. Si realizzi quindi il semplice codice Java
    che, usando il pattern Decorator, realizzi l’interfaccia Pietanza che fornisce l’unico metodo costo(). Si spieghi anche,
    sempre a parole, in modo breve e preciso, cosa cambierebbe se si volessero aggiungere dei vincoli tra i diversi condimenti (ad
    esempio, si volesse vietare il suddetto pesto con la panna).
 */

public abstract class Topping implements Food {}

class Pesto extends Topping{
    private Food base;
    private final double price = 2.50;
    private String ingredients = "pesto ";

    public Pesto(Food base) {this.base = base;}

    @Override
    public String getIngredients() {
        return base.getIngredients() + ingredients;
    }

    @Override
    public double cost() {
        return price+base.cost();
    }
}

class Cream extends Topping{
    private Food base;
    private final double price = 1.50;
    private String ingredients = "cream ";

    public Cream(Food base) {this.base = base;}

    @Override
    public String getIngredients() {
        return base.getIngredients() + ingredients;
    }

    @Override
    public double cost() {
        return price+base.cost();
    }
}

class Mushrooms extends Topping{
    private Food base;
    private final double price = 3.00;
    private String ingredients = "mushrooms ";

    public Mushrooms(Food base) {this.base = base;}

    @Override
    public String getIngredients() {
        return base.getIngredients() + ingredients;
    }

    @Override
    public double cost() {
        return price+base.cost();
    }
}

class Peas extends Topping{
    private Food base;
    private final double price = 1.00;
    private String ingredients = "peas ";

    public Peas(Food base) {this.base = base;}

    @Override
    public String getIngredients() {
        return base.getIngredients() + ingredients;
    }

    @Override
    public double cost() {
        return price+base.cost();
    }
}