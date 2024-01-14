package exams.e2019_06_19.exercise_1;

/*
 * Esercizio 1 (8 punti)
    Il metodo statico sudoku() prende in ingresso la solita griglia 9 x 9 del Sudoku, come array di int bidimensionale, e
    restituisce un boleano: true se la configurazione corrente della griglia non viola le regole del gioco; false altrimenti.
    Supponendo che il metodo venga usato per controllare solo griglie complete, si defiscano:
    
    • gli elementi della precondizione, ovvero quanto si deve dire per essere certi che la griglia abbia la “forma” corretta e che
        contenga solo numeri da 1 a 9 (si ricordi l’ipotesi di griglia completa).
    
    • gli elementi della postcondizione per dire che nessuna riga e nessuna colonna contiene numeri ripetuti.
    
    • gli elementi della postcondizione per dire che nessuna delle 9 sotto-regioni 3 ⇥ 3 contiene numeri ripetuti. Per con-
        venienza, `e possibile definire un metodo helper se necessario. Nel caso, `e richiesta l’implementazione completa del
        metodo.
    
    Si spieghi anche, a parole, in modo breve ma preciso, cosa cambierebbe se il metodo fosse usato anche per controllare
    griglie incomplete.
 */

public class Specs {
    
    /*
     * @requires s != null && s.length == 9 && (\forall int i; i >= 0 && i < s.length; s[i].length == 9) 
     *                                      && !(\exists int i,j; i >= 0 && i < 9 && j >= 0 && j < 9; s[i][j] < 1 || s[i][j] > 9);
     * @ensures (\result == true) <==> (\forall int i; i >= 0 && i < 9;
     *                                    (\forall int j; j >= 0 && j < 9; 
     *                                      !(\exists int k; k >= 0 && k < 9 && k != j; s[i][j] == s[i][k] || s[j][i] == s[k][i])));
     *                              && (\forall int mulr, mulc; mulr >= 0 && mulr < 3 && mulc >= 0 && mulc < 3;
     *                                   (\forall int c,r; c >= 0 && c < 3 && r >= 0 && r < 3; 
     *                                      !(exists int cd,rd; cd >= 0 && cd < 3 && rd >= 0 && rd < 3; rd != r && cd != c &&
     *                                          s[r + mulr*3][c + mulc*3] == s[rd + mulr*3][cd + mulc*3]) )))
     */
    Boolean sudoku(int[][] s){return false;};
}
