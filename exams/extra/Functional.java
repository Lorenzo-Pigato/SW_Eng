package exams.extra;

import java.util.Arrays;
import java.util.List;

public class Functional {
    public static int method(int v, List<String> values){
        return values.stream().filter(str-> str.length() >= 3)
                              .map(str -> str.charAt(0) == 'A' ? 1 : str.length())
                              .map(n -> v == 0 ? 0 : n)
                              .reduce(0, (a,b) -> Integer.sum(a, b));
    }
}

class Main {
    public static int method(int v, List<String> values) {
        int chars = 0;
        if (values == null || v == 0)
            return 0;
        for (String s : values) {
            if (s.length() >= 3)
                if (s.charAt(0) != 'A')
                    chars += s.length();
                else
                    chars += 1;
        }
        return chars;
    }

    public static void main(String[] args) {
        List<String> vals = Arrays.asList("lorem", "ipsum", "sit", "dolorem", "et");
        System.out.println(Functional.method(1, vals));
        System.out.println(Main.method(1, vals));
    }

}