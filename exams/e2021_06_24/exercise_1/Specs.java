package exams.e2021_06_24.exercise_1;

/*
 * Esercizio 1 (8 punti)
    Usando Java e JML si definiscano l’intestazione e la specifica di:
    • un metodo che prende in ingresso tre stringhe e restituisce true, se la terza stringa contiene almeno i caratteri delle prime
    due; false altrimenti. Cosa cambierebbe se le prime due stringhe avessero dei caratteri ripetuti e si volesse tener conto
    anche del numero di ripetizioni? Cosa cambierebbe se anzich´e dire “almeno”, volessimo dire che la terza stringa deve
    contenere “solamente” i caratteri delle prime due?
    
    • un metodo che prende in ingresso due array di interi e controlla che: (i) la lunghezza del primo array sia sempre minore
    di quella del secondo, (ii) le ripetizioni nel primo array siano di cardinalit`a minore che nel secondo, ovvero se nel primo
    array ci sono tre 45, nel secondo devono essercene almeno 4 e (iii) la differenza tra la somma dei numeri del secondo
    array e quella del primo `e sempre positiva.
 */

public class Specs {

    /*
     * @requires s1 != null && s2 != null && s3 != null;
     * @ensures (\result == true) <==> (\forall int i; i >= 0 && i < s3.length(); 
     *                                      (\exists int j; j >= 0 && j < s1.length(); s3.charAt(i) == s1.charAt(j)) &&
     *                                      (\exists int j; j >= 0 && j < s2.length(); s3.charAt(i) == s2.charAt(j))
     *                                  )
     * 
     * @signals (NullArgsException nae) s1 == null || s2 == null || s3 == null;
     */
    public /*@ pure @*/ boolean method1(String s1, String s2, String s3){return false;}

    /*
     * @requires s1 != null && s2 != null && s3 != null;
     * @ensures (\result == true) <==> (\forall int i; i >= 0 && i < s3.length(); 
     *                                      (\num_of int j; j >= 0 && j < s1.length(); s3.charAt(i) == s3.charAt(j) && i!=j) == (\max
     *                                             ((\num_of int j; j >= 0 && j < s1.length(); s3.charAt(i) == s2.charAt(j)),
     *                                             ((\num_of int j; j >= 0 && j < s2.length(); s3.charAt(i) == s1.charAt(j)),
     *                                      )                                           
     *                                  ) || (*not exists same char in s1 or s2*);
     * 
     * @signals (NullArgsException nae) s1 == null || s2 == null || s3 == null;
     */
    public /*@ pure @*/ boolean method1B(String s1, String s2, String s3){return false;}

    /*
     * @requires s1 != null && s2 != null && s3 != null;
     * @ensures (\result == true) <==> (\forall int i; i >= 0 && i < s3.length(); 
     *                                      !(\exists int j; j >= 0 && j < s1.length(); s3.charAt(i) != s1.charAt(j)) &&
     *                                      !(\exists int j; j >= 0 && j < s2.length(); s3.charAt(i) != s2.charAt(j))
     *                                  )
     * 
     * @signals (NullArgsException nae) s1 == null || s2 == null || s3 == null;
     */
    public /*@ pure @*/ boolean method1C(String s1, String s2, String s3){return false;}

    /*
     * @requires a != null && b != null;
     * @ensures (\result == true) <==> (a<length < b.length &&
     *                                  (\num_of int i; i >= 0 && i < a.length; 
     *                                      (\exists int j >= 0 && j < a.length && j != i; a[i] == a[j]))
     *                                    <
     *                                  (\num_of int i; i >= 0 && i < b.length; 
     *                                      (\exists int j >= 0 && j < b.length && j != i; b[i] == b[j])) &&
     *                                  (\sum int i; i >= 0 && i < a.length; a[i]) > (\sum int i; i >= 0 && i < b.length; b[i]))
     * 
     * @signals (NullArgsException nae) a == null || b == null;
     */
    public /*@ pure @*/ boolean method2(int[] a, int[] b){return false;}
    
}
