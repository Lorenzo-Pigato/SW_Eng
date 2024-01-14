package exams.e2020_01_14.exercise_4;

/*Esercizio 4 (6 punti)
Si consideri il seguente frammento di codice Java.*/

class A {
    public void g(A x) {
        System.out.println("called on instance of A");
    }
}

class B extends A {
    public void g(A x) {
        System.out.println("called 1 on instance of B");
    }

    public void g(B x) {
        System.out.println("called 2 on instance of B");
    }
}

class Test {
    public static void f(A x) {
        System.out.println((x instanceof A) + " A");
    }

    public static void f(B x) {
        System.out.println((x instanceof B) + " B");
    }

    public static void main(String s[]) {
        A a = new A();
        A ab = new B();
        B b = new B();
        f(a);
        f(ab);
        f(b);
        f((A) b);
        b.g(a);
        ab.g(ab);
        b.g(b);
    }
}