package Exercise.Exercise_9;

import java.util.ArrayList;

/*
    Esercizio 1 / Functional ArrayList
    
    👉  Data una lista di elementi di tipo Triangle, deﬁnita come List<Triangle>

    👉  Map: deﬁnire una funzione che trasforma i triangoli in quadrati che abbiano la
        stessa area e applicare la funzione usando map.

    👉  Filter: deﬁnire una funzione che ritorni true se il perimetro del triangolo e’
        dispari e applicare la funzione usando ﬁlter.

    👉  Reduce: deﬁnire una funzione che somma l’area di due triangoli e applicare la
        funzione per trovare l’area totale dei triangoli nella lista.
 */

public class FunctionalArray extends ArrayList<Triangle> {
    private ArrayList<Triangle> triangles;
    
    public FunctionalArray(ArrayList<Triangle> triangles) {
        this.triangles = triangles;
    }
    
    public ArrayList<Square> map(){
        ArrayList<Square> squares = new ArrayList<>();

        for (Triangle triangle: triangles) {
            squares.add(new Square(Math.sqrt(triangle.getSurfaceArea())));
        }

        System.out.println(squares);
        return squares;
    }

    public ArrayList<Boolean> filter(){
        ArrayList<Boolean> odd = new ArrayList<>();
        
        for (Triangle triangle : triangles) {
            odd.add((triangle.getPerimeter()%2 != 0));
        }

        return odd;
    }

    public double reduce(){
        double sum = 0;

        for (Triangle triangle : triangles) {
            sum += triangle.getSurfaceArea();
        }

        return sum;
    }
} 

