package Exercise.Excercise_1;

/*
Ingegneria del Software
Esercitazione - Introduzione
09 Ottobre 2023

Esercizio 1 / Stack
Deﬁnire una classe stack di interi
(Struttura dati LIFO)
👉  La struttura dati ha una dimensione ﬁnita e arbitraria. Il valore di default e’ 10.
👉  Metodo pop ritorna l’ultimo elemento e lo rimuove dallo stack.
👉  Metodo push aggiunge un elemento allo stack.
*/

class Stack {
    private int[] stack;
    
    private int stackSize;
    private int stackIndex = -1;

    public Stack(int stackSize){
        this.stackSize = stackSize;
        stack = new int[stackSize];
    }

    public Stack(){
        this(10);
    }

    public Integer pop() {
        if (stackIndex >= 0) {
            stackIndex--;
            return stack[stackIndex + 1];
        }

        else
            return null;
    }

    public void push(int element) {
        if (stackIndex < stackSize-1) {
            stackIndex++;
            stack[stackIndex] = element;

            System.out.println("Inserted a element");
        }

        else
            System.out.println("Stack is full");
    }
}

public class MainStack {
    public static void main(String[] args){
        Stack myStack = new Stack(5);
        
        myStack.push(11);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        myStack.push(7);
        myStack.push(9);
        myStack.push(13);
        myStack.push(17);
        myStack.push(21);
        myStack.push(19);
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
        System.out.println(myStack.pop());
    }
}
