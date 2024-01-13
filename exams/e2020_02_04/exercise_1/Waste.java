package exams.e2020_02_04.exercise_1;

/*
 * Esercizio 1 (9 punti)
    Un comune virtuoso vuole facilitare la raccolta differenziata e ragiona sui concetti di Contenitore e Spazzatura. Ogni
    contenitore pu`o accogliere solamente spazzatura di un certo tipo (carta, vetro, metallo, indiffenziata) fino al massimo delle sua
    capienza. Ogni elemento Spazzatura deve essere classificato in base ad una delle quattro tipologie precedenti ed ha un
    volume. L’idea `e che ogni cittadino venga dotato di 4 contenitori intelligenti. A fronte di queste informazioni:
    • Si definisca una rappresentazione (plausibile) per le due classi in Java.
    • Si definiscano gli invarianti privati delle due classi in JML.
    • Si definisca la specifica JML del metodo gettaVia della classe Contenitore, che consente all’utente di buttare
    della spazzatura di tipo opportuno nel contenitore preposto. Il metodo non deve consentire di buttare un elemento nel
    contenitore sbagliato e neppure di buttare un elemento nel contenitore giusto se il suo volume supera la capienza rimasta.
 */


public interface Waste {
    public String getType();
    public double getVolume();
}

 /* 
  * @ public invariant type != null && volume > 0;
  */
class Generic implements Waste {
    private final String type = "Generic";
    private double volume;

    public Generic(double volume){
        this.volume = volume;
    }

    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }
}

class Paper implements Waste {
    private final String type = "Paper";
    private double volume;

    public Paper(double volume){
        this.volume = volume;
    }
    
    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public double getVolume() {
        return this.volume;
    }
}

// ...
