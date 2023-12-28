package Exercise.Exercise_7;

public class Main {

    public static void main(String[] args) {
        SafeStack<Integer> integerSafeStack = new SafeStack<>(20);
        SafeStack<String> stringSafeStack = new SafeStack<>(5);

        integerSafeStack.safePush(10);
        integerSafeStack.safePop();
        integerSafeStack.safePop();

        integerSafeStack.safePush(11);
        integerSafeStack.safePush(33);
        integerSafeStack.safePush(77);
        
        for (Integer val : integerSafeStack) {
            System.out.println(val);
        }

        stringSafeStack.safePush("typo");
        stringSafeStack.safePop();
    }

}
