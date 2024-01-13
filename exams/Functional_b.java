package exams;

import java.util.List;

/*
 * Esercizio 3 (4 punti)
    Si consideri il seguente metodo statico Java.
    public static int method(int v, List<String> values) {
        int chars =0;
        if (values == null || v == 0) return 0;
        for (String s : values) {
            if (s.length() >= 3)
                if (s.charAt(0) != ’A’) chars += s.length();
            else chars += 1;
        }
        return chars;
    }
    e si riscriva la stessa funzione in stile funzionale.
 */
public class Functional_b {
    public static int method(int v, List<String> values){
        return (v == 0 || values == null ? 0 : values.stream().filter(s -> s.length() >= 3)
                                                              .map(s -> (s.charAt(0) != 'A' ? s.length() : 1))
                                                              .reduce(0, (a,b) -> Integer.sum(a, b)));
                                                              
    }
}
