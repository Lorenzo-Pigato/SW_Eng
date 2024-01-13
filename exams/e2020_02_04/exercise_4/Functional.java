package exams.e2020_02_04.exercise_4;

import java.util.List;

/*
 * Esercizio 4 (6 punti)
    Si consideri il seguente metodo statico Java.
    public static int foo(Integer v, List<Integer> values) {
        int sum =0;
        if (values == null || v == null ) return 0;
        for (Integer x : values) {
            if (x%3 == 0) sum += v;
            else sum += x%3;
        }
        return sum;
    }
    e si riscriva la stessa funzione in stile funzionale.
 */

public class Functional {
    public int method(Integer v, List<Integer> values){
        return (v == null || values == null ? 0 : values.stream().map(x -> (x % 3 == 0 ? v : x%3))
                                                                 .reduce(0, (a,b) -> Integer.sum(a,b)));
    }
}
