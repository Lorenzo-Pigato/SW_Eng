package exams.e2016_28_09.exercise_5;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Method {
    public int proceduralMethod (ArrayList<String> strings) {
        int result = 0;
        for (String string : strings) {
            string = string.replaceAll("tt", "").replaceAll("cc", "").replaceAll("ll", "");
            result += string.length();
        }

        return result;
    } 

    public int functionalMethod (ArrayList<String> strings) {
        List<String> targets = Arrays.asList("cc", "ll", "tt");

        return strings.stream() .map(str -> targets.stream()
                                .reduce(str, (string, substring) -> string.replaceAll(substring, ""))
                                .length())
                                .reduce(0, (a, b) -> Integer.sum(a, b));
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("null", "raccoon", "accordion", "attic"));
        new Method().functionalMethod((ArrayList<String>)(list));
    }
}
