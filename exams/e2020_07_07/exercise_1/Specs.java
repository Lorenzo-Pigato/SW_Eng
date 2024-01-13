package exams.e2020_07_07.exercise_1;

import java.util.ArrayList;

/*
 * Esercizio 1 (9 punti)
    Si scrivano le pre- e post-condizioni in JML per i seguenti metodi statici:
        
        • Il metodo m1 prende in ingresso un arrayList ai di interi, anche ripetuti, e un intero n e restituisce un altro arrayList di
          interi. Il risultato deve contenere solo gli interi in ai ripetuti almeno n volte. Ogni intero nell’arrayList restituito deve
          comparire una volta sola.
    
        • Il metodo m2 prende in ingresso un array di caratteri e restituisce true se i caratteri nell’array rispettano l’ordine
          alfabetico, f alse altrimenti.
    
        • Il metodo m3 prende in ingresso un array di stringe ed un’ulteriore stringa. Il metodo non restituisce nulla e aggiunge la
          stringa all’array solo nel caso in cui nell’array non esista gi`a una stringa che inizi con lo stesso carattere.
 */

public class Specs {
    
    /*
     * @ requires nums != null && n>0
     * @ ensures (\forall int i; i >= 0 && i < nums.size(); 
     *              (\num_of int j; j >= 0 && j < nums() && j != i; nums.get(i) == nums.get(j)) >= n) <==> \result.contains(nums.get(i))
     * @ ensures (\forall in i; i >= 0 && i < \result.size(); 
     *              !(\exists int j; j >= 0 && j < \result.size() && i != j; \result.get(i) == \result.get(j))) 
     */
    /* @ pure @*/ ArrayList<Integer> method1 (ArrayList<Integer> nums, int n){return null;}

    /*
     * @ requires c != null;
     * @ ensures (\result == true) <==>(\forall int i; i >= 0 && i < c.length-1; 
     *              (\forall int j; j>i && j < c.length; (int) c[i] > (int) c[j]));
     */
    /* @ pure @*/ boolean method2(char[] c){return false;}

    /*
     * @ requires strings != null && str != null
     * @ ensures (\forall int i; i >= 0 && i < strings.length; 
     *              !(\exists (Character.toLowerCase(\old.strings[i].charAt(0)) == Character.toLowerCase(str.charAt(0)) 
     *                 <==> (strings.get(\old.strings.size()) == str);
     */
    void method3 (String[] strings, String str){}

}
