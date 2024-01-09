package exams.e2022_06_24.exercise_1;

/*
 * Esercizio 1 (4 punti)
Si definisca l’intestazione dei due metodi statici seguenti e la loro specifica JML.
• Il metodo prende in ingresso un array di stringhe a, una stringa s ed un intero n e aggiunge s all’array se la stringa ha
lunghezza pari (dispari) e a non contiene gi`a n stringhe di lunghezza pari (dispari).

• Il metodo prende in ingresso due array di caratteri x e y e restituisce, in un array di interi, l’elenco, in ordine qualunque,
di tutte e sole le posizioni in cui gli elementi dei due array sono uguali.
La specifica deve gestire in modo appropriato gli eventuali problemi con i parametri in ingresso
 */

public class Specs {

    /*
     * @requires s != null && a != null && n > 0;
     * @ensures (\exists int i; i >= 0 && i < a.length; a[i].equals(s) && !\old.a[i].equals(s)) <==> 
     *                  (\num_of ; int j; j >= 0 && j < s.length; a[j].size()%2 == s.size()%2) < n;
     * @signals (InvalidArgumentExceprion iae) s == null || a == null || n <= 0;
     */
    void method1(String[] a, String s, int n) {}

    /*
     * @requires x != null && y != null
     * @ensures (\result.length > 0) <==> (\forall int i; i >= 0 && i < \result.length; x[\result[i]] == y[\result[i]]) 
     * @signals (NullArgumentException nae) x == null || y == null 
     */
    int[] method2(char[] x, char[] y){return null;}
}
