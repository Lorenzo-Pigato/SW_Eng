package exams.e2022_02_11.exercise_2;

public class FindTheMistake {
    static public void main(String[] argc) {
        Persona p = new Persona("Filippo");
        Autista au1 = new AutistaCamion("Maria");
        //Auto a = new Auto();
        Auto ac = new Camion();
        Camion c = new Camion();
        p.guida(ac);
        p = new Autista("Luigi");
        AutistaCamion au2 = new AutistaCamion("Gianni");
        au2.guida(c);
        //p.guida(p, au1);
        au1.guida(c, au2);
        p.guida(c);
        //au2.guida((Camion) a, au1);
    }
}

class Persona {
    protected String nome;

    public Persona(String nome) {
        this.nome = nome;
    }

    public void guida(Auto a) {
        System.out.println(nome + " guida " + a.modello());
    }

}

class Autista extends Persona {
    public Autista(String nome) {
        super(nome);
    }

    public void guida(Camion c) {
        System.out.println("Autista " + nome + " guida " + c.modello());
    }

    public void guida(Camion c, Autista secondo) {
        System.out.println("Autista " + nome + " guida " + c.modello() + " con " + secondo.nome);
    }
}

class AutistaCamion extends Autista {
    public AutistaCamion(String nome) {
        super(nome);
    }

    public void guida(Auto a) {
        System.out.println("Autista camion " + nome + " guida " + a.modello());
    }
}

class Auto {
    public String modello() {
        return "auto AA";
    }
}

class Camion extends Auto {
    public String modello() {
        return "camion CC";
    }
}
