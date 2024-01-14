package exams.e2019_06_19.exercise_2;

import java.util.ArrayList;

/*
 * Esercizio 2 (6 punti)
    Si scriva una classe Java che rappresenta una lista (FIFO) concorrente e di 10 elementi al massimo. La classe consente ad
    oggetti/thread di accedere alla struttura dati in modo concorrente, senza chiaramente violare le regole di base relative agli
    accessi multipli. La classe offre i metodi leggi, per leggere il primo elemento utile (il primo inserito ed ancora presente)
    senza rimuoverlo, scrivi, per scrivere un elemento (e metterlo in ultima posizione), e cancella per rimuovere l’elemento
    in testa alla lista. Non deve chiaramente essere possibile leggere o cancellare elementi da una lista vuota o scriverne di nuovi
    in una lista piena. La classe deve fornire anche un metodo vuota che restituisce lo stato della lista: true se la lista `e vuota;
    false altrimenti.
 */

public class Fifo <T> {
    private ArrayList<T> stack = new ArrayList<>();

    static class InvalidPushException extends Exception{
        @Override
        public String getMessage() {
            return ("Exceeding stack size");
        }
    }

    static class InvalidReadException extends Exception{
        @Override
        public String getMessage() {
            return ("Stack is already empty");
        }
    }

    public synchronized void push(T element) throws InvalidPushException{
        if(stack.size() < 10) this.stack.add(element);
        else throw new InvalidPushException();
    }
    
    public synchronized T pop() throws InvalidReadException{
        if(stack.size() == 0) throw new InvalidReadException();
        T res = this.stack.get(stack.size()-1);
        stack.remove(stack.size()-1);
        return res;
    }

    public synchronized T read() throws InvalidReadException{
        if(stack.size() == 0) throw new InvalidReadException();
        return stack.get(stack.size()-1);
    }

}
