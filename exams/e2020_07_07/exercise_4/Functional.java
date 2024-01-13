package exams.e2020_07_07.exercise_4;

import java.util.List;

/*
 * Esercizio 4 (4 punti)
    Data una lista di stringhe List<String> list, si definisca un metodo in stile funzionale che conti e restituisca il numero
    di consontanti contenute nelle stringhe. 
 */

public class Functional {
    int method (List<String> list){
        return (int) list.stream().flatMapToInt(str -> str.chars()
                                                          .filter(c -> !"aeiouAEIOU".contains(String.valueOf(c))))
                                  .count();
    }
}
