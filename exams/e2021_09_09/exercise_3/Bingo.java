package exams.e2021_09_09.exercise_3;

import java.util.Iterator;
import java.lang.Iterable;
import java.util.ArrayList;
import java.util.Collections;

public class Bingo implements Iterable<Integer>{
    private ArrayList<Integer> numbers = new ArrayList<Integer>();
    private boolean [] extracted = new boolean[90];
    private int extractions = 0;

    public Bingo(){
        for(int i = 1; i <= 90; i++)
            numbers.add(i);

        Collections.shuffle(numbers);
    }

    public boolean[] getExtracted() {
        return extracted;
    }

    public int getExtractions() {
        return extractions;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new BingoIterator();
    }

    class BingoIterator implements Iterator<Integer> {
        int index = 0;

        @Override
        public boolean hasNext() {
            if(index < numbers.size()) return true;
            return false;
        }

        @Override
        public Integer next() {
            extracted[numbers.get(index)-1] = true;
            extractions++;
            return numbers.get(index++);
        }
    }

    public static void main(String[] args) {
        Bingo bingo = new Bingo();
        
        for (Integer number : bingo) {
            System.out.println(number);
        }

        System.out.println("Total extractions: " + bingo.getExtractions());
    }
}
