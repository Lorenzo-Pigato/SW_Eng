package exams.e2016_07_20.exercise_2;

/*
Esercizio 2 (5 punti)

Una paninoteca vuole poter offrire ai propri clienti la massima flessibilità nella creazione dei panini. Ogni panino parte da una
base, ovvero dal tipo di pane: bianco, arabo o multi-cereale. A questa, i clienti possono aggiungere Crudo, Cotto, Salame, o
Tonno e poi anche Pomodoro, Mozzarella, Lattuga, Insalata Iceberg o Capperi. La paninoteca vorrebbe anche avere un sistema
che con il tempo possa essere espanso con l’aggiunta di nuovi ingredienti.
Si realizzi un diagrmma delle classi UML che “risolva” il problema sopra descritto. L’uso di design pattern appropriati
verrà valutato positivamente. Si scriva anche la struttura delle classi principali in Java.
 */


// Component interface
public interface Sandwich {
    public void assembly();
}

// Concrete component
class EmptySandwich implements Sandwich {
    @Override
    public void assembly() {
        System.out.println("New empty sandwich ready");
    }
}

class Main {
    public static void main(String[] args) {
        Sandwich mySandwich = new Mozzarella(new Tomatoes(new Ham (new WhiteBreat(new EmptySandwich()))));
        mySandwich.assembly();
    }
}