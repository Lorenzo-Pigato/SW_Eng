package exams.e2022_01_24.exercise_4;

import java.util.Arrays;
import java.util.List;

/*
 * Esercizio 4 (3 punti)
    Adottando uno stile di programmazione funzionale, si definisca in Java una funzione statica che prende una lista di parole ed
    un carattere come parametri e restituisce il numero di parole che contengono il carattere. Il carattere passato come parametro
    pu`o essere maiuscolo o minuscolo e lo stesso vale per i caratteri delle parole nella lista: la funzione deve contare comunque il
    numero di parole ignorando eventuali differenze di rappresentazione.
 */
public class FuctCharQty {
    static int method(List<String> words, char c){
        return (int) words.stream().map(str -> str.toLowerCase())
                                   .filter(str -> str.chars()
                                                     .anyMatch(chr -> chr == Character.toLowerCase(c)))
                                   .count();
    }

    public static void main(String[] args) {
        List<String> str = Arrays.asList("lorem", "ispum", "Sit", "dolorem");
        System.out.println(FuctCharQty.method(str, 'S'));
    }
}
