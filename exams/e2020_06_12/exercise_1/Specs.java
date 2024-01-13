package exams.e2020_06_12.exercise_1;

import java.util.ArrayList;

/*
 * Parte A (9 punti)
    Si scrivano le pre- e post-condizioni in JML per i seguenti metodi statici:
    • Il metodo m1 prende in ingresso un arrayList di Stringhe e restituisce un’altro arrayList di Stringhe. Il risultato deve
      contenere solo il sottoinsieme delle stringhe in input di lunghezza pari e che non contengano pi`u di 2 a. Per semplicit`a si
      supponga che le stringhe contengano solo caratteri minuscoli.
    
    • Il metodo m2 prende in ingresso un array di caratteri e restituisce true se l’array contiene almeno un carattere ripetuto,
      f alse altrimenti.
    
    • Il metodo m3 prende in ingresso un arraList di interi e un numero intero n. Il metodo aggiunge l’elemento all’arrayList
      se l’arrayList stesso non contiene gi`a n o un numero divisibile per n.
 */

public class Specs {

    /*
     * @requires a != null;
     * @ensures \result != null;
     * @ensures (\forall String s; a.contains(s); 
     *              \result.contains(s)<==> (s.length() % 2 == 0 && 
     *                                      (num_of int i; i >= 0 && i <= s.length(); s[i] == 'a') <= 2)
     */
    /*@ pure @*/ public ArrayList<String> method1 (ArrayList<String> a){return null;}

    /*
     * @requires c != null;
     * @ensures \result <==> (\exists int i; i >= 0 && i < c.length; 
     *                          (num_of int j; j >= 0 && j < c.length && j != i; c[i] == c[j]) == 1);
     */
    /*@ pure @*/ public boolean method2 (char[] c){return false;}

    /*
     * @requires a != null;
     * @ensures (\forall int num, \old.a.contains(num); a.contains(num));
     * @ensures (a.get(\old.a.size()) == n <==> !(\exists k; \old.a.contains(k); k == n || k%n == 0));
     */
    public void method3 (ArrayList<Integer> a, int n){}

    /*
     * Parte B (4 punti)
     * Si definisca una semplice classe Rettangolo. Ogni rettangolo `e
     * caratterizzato da un’altezza e da una larghezza e non
     * pu`o mai essere degenere, ovvero avere lati lunghi 0 o diventare un quadrato.
     * Si usi JML per:
     *  • Definire l’invariante privato della classe Rettangolo.
     *  • Ipotizzando che esista un costruttore, che non deve essere definito, che
     *    consente di creare rettangoli di altezza e larghezza
     *    dati, definire le pre- e post-condizioni di un metodo cambiaLarghezza che
     *    consente di cambiare la sola larghezza
     *    del rettangolo.
     */
     
     /*
      * @public invariant (width != heigth) && width > 0 && heigth > 0
      */
     class Rectangle {
        public Rectangle(int width, int heigth){}
        
        /*
         * @assignable width, heigth
         * @requires newWidth > 0 && newHeigth > 0 && newWitdh != newHeigth
         * @ensures width == newWidth && heigth == newHeigth;
         */
        public void change(int newWidth, int newHeigth){}
     }
    
}
