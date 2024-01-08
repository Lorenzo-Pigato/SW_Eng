package exams.e2016_02_02.exercise_5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

public class FunctionalMethod {
    public static List<Integer> method(ArrayList<String> strings) {
        return strings.stream().map(str -> (int)str.toLowerCase().chars()
                                                            .filter(c -> c == 'a')
                                                            .count())
                                .collect(Collectors.toList());
    }

    public static int method_2(ArrayList<String> strings){
        return strings.stream().map(str ->(int)str.toLowerCase().chars()
                                                                .filter(c -> c == 'a')
                                                                .count())
                                .reduce(0, (a, b) -> Integer.sum(a, b));
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList("alpha", "beta", "gamma"));
        System.out.println(method(list));
        System.out.println(method_2(list));
    }
}
