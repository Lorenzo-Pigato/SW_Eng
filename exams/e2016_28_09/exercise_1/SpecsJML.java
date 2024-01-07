package exams.e2016_28_09.exercise_1;

import java.util.ArrayList;

public class SpecsJML {
    
    /*
     * @(*returns number of chars inside s[] after p chars*)
     * @requires s != null && p >= 0;  
     * @ensures \result == \sum((\forall int i; 0<= i && i<s.length();
     * @             (s[i].length() >= p) ==> (p-s[i].lenth()));
     */
    int method1 (String[] s, int p){return 0;}

    /*
     * @requires a != null && d1 < d2;
     * @ensures (/result == 0) <==> (d1 < 0 || d2 >= a.length()) &&
     * @        (\result == \sum(\forall int i; d1<=i <= d2; a[i]);
     */
    int method2 (int[] a, int d1, int d2) {return 0;}

    /*
     * @requires v1<=v2;
     * @ensures \result.contains((\forall int i; v1<=i<=v2; 
     *              !(\exists int j; v1>=j<=v2; i%j==0));
     */
    ArrayList<Integer> method3 (int v1, int v2) {return null;}
}

/*
 * Esercizio 2: Teoria
 * - Non è sempre necessario avere una precondizione che definisca un intero come non null
 * - Si può omettere il costruttore della sottoclasse solo qualora la superclasse abbia un costruttore di
 *   super() senza argometni, che verrà automaticamente chiamato. Nel caso il costruttore di default non fosse
 *   disponibile, sarà obbligatorio chiamare manualmente il costruttore della superclasse
 * - Il pattern stratrgy e il Decorator sono rispettivamente un pattern comportamentale e uno funzionale
 *   suppliscono quindi a due necessità differenti. Un pattern stategy permette di decidere in base al
 *   problema che si sta affrontando quale metodo di risoluzione è più efficace utilizzare, mentre un pattern
 *   decorator permette di estendere le funzionalità di un oggetto in base alle necessità. In sintesi, uno cambia
 *   il metodo d'approccio al problema, l'altro implementa funzioni aggiuntive in base alle necessità
 * - Coprire tutte le decisioni implica aver coperto tutte le condizioni, ma coprire tutte le condizioni non vuol dire
 *   necessariamente aver coperto tutte le decisioni, potrebbero esservi branch che non sono stati esplorati.
 *   Le due coperture non sono quindi equivalenti
 */
