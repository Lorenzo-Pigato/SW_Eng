package exams.extra;

class A{
    public void display(){System.out.println("A");}
    public void displayB(){System.out.println("INSIDE-A");}
}

class B extends A{
    public void display(){System.out.println("B");}
}

public class Test{

    public static void main(String[] args) {
        A a = new A();
        A ab = new B();
        B b = new B();
        A ba = new B();

        
        b = (B)ab;
        ba.displayB();
        System.out.println("a istance of A: " + (a instanceof A));
        System.out.println("ab istance of A: " + (ab instanceof A));
        System.out.println("b istance of B: " + (b instanceof B));
        System.out.println("ab istance of B: " + (ab instanceof B));
        System.out.println("ba istance of A: " + (ba instanceof A));
        System.out.println("ba istance of B: " + (ba instanceof B));

    }

}
