package exams.e2016_07_06.exercise_4;

/*
Esercizio 4 (7 punti)
Si consideri una classe Roditore che ha due sotto-classi Ratto e Topo. Inoltre, la classe Topo ha come sotto-classe
Topolino. Si consideri il frammento di codice seguente e si identifichino le righe di codice che darebbero un errore in com-
pilazione (spiegare brevemente le risposte):
1 Roditore ro;
2 Ratto ra = new Ratto();
3 Topo to = new Topo();
4 Topolino tn = new Topolino();
5 ro = ra;
6 to = tn;
7 tn = new Roditore();
8 ra = new Topolino();
9 Roditore[] array = new Ratto[10];
10 Roditore[] array = new Roditore[10];
11 Ratto[] array = new Topolino[10];
 */


@SuppressWarnings ("unused")
public class Main {
    public static void main(String[] args) {
        Roditore ro;
        Ratto ra = new Ratto();
        Topo to = new Topo();
        Topolino tn = new Topolino();
        ro = ra; // Permitted because Roditore  is superclass of ratto
        to = tn;
        tn = new Topolino(); // Roditore is a superclass of Topolino, so tn can't be initialized to its superclass
        ra = new Ratto(); // Topolino is not a subclass of Ratto

        // array could not be initialized more than once, so names mus be changed
        Roditore[] arrayRatto = new Ratto[10];
        Roditore[] arrayRoditore = new Roditore[10];

        // Topolino is not a subclass of ratto, so it's not possible to initialize a
        // Ratto to a Topolino
        Topo[] array = new Topolino[10];
    }
}

class Roditore {
}

class Topo extends Roditore {
}

class Topolino extends Topo {
}

class Ratto extends Roditore {
}
