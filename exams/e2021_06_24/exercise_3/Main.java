package exams.e2021_06_24.exercise_3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
 * Esercizio 3 (4 punti)
    Si definisca in Java un metodo (statico) che prende in ingresso una lista di interi ed una lista di predicati. La funzione deve
    applicare i predicati alla lista per filtrarla e restituire poi la somma dei numeri rimanenti. Ad esempio, i predicati potrebbero
    dire che il risultato deve essere la somma dei soli valori non negativi, minori di 100 e multipli di 7.
 */

public class Main {
    private List<Predicate<Integer>> predicates = new ArrayList<>();
    private List<Integer> numbers = new ArrayList<>();

    public Main() {
        predicates.add(new Predicate<Integer>() {
            public boolean test(Integer t) {
                return t % 2 == 0;
            }
        });

        predicates.add(new Predicate<Integer>() {
            public boolean test(Integer t) {
                return t > 5;
            }
        });

        predicates.add(new Predicate<Integer>() {
            public boolean test(Integer t) {
                return t < 10;
            }
        });

        for (int i = 0; i < 10; i++) {
            numbers.add(Integer.valueOf(((int) (Math.random()*30))));
            System.out.print(numbers.get(i) + " ");
        }

        System.out.println();

    }

    public static int mehod(List<Integer> numbers, List<Predicate<Integer>> predicates) {
        return numbers.stream().filter(n -> predicates.stream().allMatch(p -> p.test(n)))
                .reduce(0, (a, b) -> Integer.sum(a, b));
    }

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(Main.mehod(main.numbers, main.predicates));
    }
}
