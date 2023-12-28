package Exercise.Exercise_7;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/*
    Esercizio 4 / SafeStack
    Si progetti la classe SafeStack.
        👉  Deﬁnire il metodo SafePush che gestisce correttamente i casi limite
            dell’inserimento di nuovi elementi.
    
        👉  Deﬁnire il metodo SafePop che gestisce correttamente i casi limite
            dell’estrazione degli elementi nello stack.
    
        👉 Rendere la classe Stack tipizzabile con i Generics
        
        👉 Rendere iterabile la classe Stack (con Iterator<T>)
 */

// Generics allow more flexibility

// Conventionally, generics are named like: 
//E - Element (used extensively by the Java Collections Framework)
//K - Key
//N - Number
//T - Type
//V - Value
//S,U,V etc. - 2nd, 3rd, 4th types

public class SafeStack<Type> implements Iterable<Type> {
    private List<Type> stack = new ArrayList<>();
    private int stackSize;

    public SafeStack(int stackSize) {
        this.stackSize = stackSize;
    }

    public void safePush(Type element) {
        try {
            if (stack.size() >= this.stackSize)
                throw new FullStackException(this.stackSize);

            stack.add(element);

        } catch (Exception e) {
            if (e instanceof FullStackException)
                System.out.println(e.getMessage());

            else
                System.out.println("Generic push error");
        }
    }

    public void safePop() {
        try {
            if (stack.isEmpty())
                throw new EmptyStackException();

            else {
                System.out.println(stack.get(stack.size()-1));
                stack.remove(stack.size()-1);
            }

        } catch (Exception e) {
            if (e instanceof EmptyStackException)
                System.out.println(e.getMessage());

            else
                System.out.println(e.getMessage());
        }
    }

    public List<Type> getStack() {
        return stack;
    }

    public int getStackSize() {
        return stackSize;
    }

    // Implementation of iterator abstract method to get an iterator object

    @Override
    public Iterator<Type> iterator() {
        return new StackIterator<Type>(this);
    }

}

final class StackIterator<Type> implements Iterator<Type> {
    private List<Type> stack;
    private int index = 0;

    public StackIterator(SafeStack<Type> stack) {
        this.stack = stack.getStack();
    }

    @Override
    public boolean hasNext() {
        if (index < stack.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Type next() {
        return stack.get(index++);
    }

}

final class FullStackException extends Exception {
    private String message;

    protected FullStackException(int stackSize) {
        message = "Stack is already full, stack size: " + stackSize;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

final class EmptyStackException extends Exception {
    @Override
    public String getMessage() {
        return "Stack is empty, can't pop";
    }
}
