package exams.e2020_02_04.exercise_3;

public abstract class Feature implements Element {

}

class Fabric extends Feature {
    enum type {
        LEATHER("leather"),
        CLOTH("cloth");

        private String name;
        
        type (String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    };

    private type fabric;
    private Element element;

    public Fabric(Element element, type fabric){
        this.fabric = fabric;
        this.element = element;
    }

    @Override
    public void display() {
        element.display();
        System.out.print(" " + fabric.getName());
    }
}


class Pockets extends Feature {
    enum type {
        EXTERN("cargo pockets"),
        INNER("inner pockets"),
        DOUBLE("double pockets");

        private String name;
        
        type (String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    };

    private type pockets;
    private Element element;

    public Pockets(Element element, type pockets){
        this.pockets = pockets;
        this.element = element;
    }
    
    @Override
    public void display() {
        element.display();
        System.out.print(" " + pockets.getName());
    }
}

class Neck extends Feature {
    enum type {
        KOREAN("korean neck"),
        HOOD("hood");

        private String name;
        
        type (String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    };

    private type neck;
    private Element element;

    public Neck(Element element, type neck){
        this.neck = neck;
        this.element = element;
    }
    
    @Override
    public void display() {
        element.display();
        System.out.print(" " + neck.getName());
    }
}

class Closure extends Feature {
    enum type {
        ZIP("zip"),
        BUTTONS("buttons");

        private String name;
        
        type (String name){
            this.name = name;
        }

        public String getName() {
            return name;
        }
    };

    private type closure;
    private Element element;

    public Closure(Element element, type closure){
        this.closure = closure;
        this.element = element;
    }
    
    @Override
    public void display() {
        element.display();
        System.out.print(" " + closure.getName());
    }
}
