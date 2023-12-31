package Exercise.Exercise_10;

import java.util.ArrayList;
import java.util.function.Predicate;

/*
    Esercizio 2 / Takewhile
    Estendere ArrayList con il metodo takewhile che prende un predicato e ritorna un
    nuovo ArrayList contente tutti gli elementi ﬁno al primo elemento che viola il
    predicato.
 */

public class ArrayTakewhile<T> extends ArrayList<T> {
    private ArrayList<T> result = new ArrayList<>(); 
    
    public ArrayList<T> takewhile(Predicate<T> condition){
        T element = this.get(0);
        
        int index = 0;

        while(condition.test(element)){
            result.add(element);
            element = this.get(++index);
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayTakewhile<Integer> integerTakewhile = new ArrayTakewhile<>();
        
        integerTakewhile.add(10);
        integerTakewhile.add(12);
        integerTakewhile.add(14);
        integerTakewhile.add(17);
        integerTakewhile.add(20);
        
        System.out.println(integerTakewhile.takewhile(n -> n%2 == 0).toString());
    }
}
