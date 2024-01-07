package exams.e2016_09_07.exercise_5;

import java.util.Arrays;
import java.util.List;

/*
Esercizio 5 (4 punti)

Si scriva un semplice metodo Java che conta il numero di vocali presenti in una lista di stringhe utilizzando un approccio
funzionale. Il punto di partenza potrebbe essere:
List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
 */

public class FunctionalVowels {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        
        System.out.println(list.stream().flatMapToInt(str -> str.toLowerCase().chars()).filter(c -> "aeiou".indexOf(c) >-1).count());
    }
}
