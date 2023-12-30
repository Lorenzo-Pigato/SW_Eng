package Exercise.Exercise_9B;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;

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

// Functional array is now implemented with generics, using Stream

public class FunctionalArray<T> extends ArrayList<T> {
    
    // Declaring a new generic <S>, to be used as output type for function map()
    public <S> ArrayList<S> map(Function<T, S> mapping){
        ArrayList<S> mapped = new ArrayList<>();

        for (T element: this) {
            mapped.add(mapping.apply(element));
        }
        
        return mapped;
    }

    public ArrayList<T> filter(Predicate<T> filtering){
        ArrayList<T> filtered = new ArrayList<>();
        
        for (T element : this) {
            if(filtering.test(element)) filtered.add(element);
        }

        return filtered;
    }

    // Define additional generic type S, BiFunction 
    public <S> S reduce(S initial, BiFunction<S,T,S> reduction){
        S result = initial;

        for (T element: this) {
            result = reduction.apply(result, element);
        }

        return result;
    }
}

class TriangleFunctions {
    public static Square mapping(Triangle triangle){
        return new Square(Math.sqrt(triangle.getSurfaceArea()));
    }

    public static Boolean filtering(Triangle triangle){
        return (triangle.getPerimeter()%2 == 0);
    }

    public static double sum(Triangle triangleA, Triangle triangleB){
        return triangleA.getSurfaceArea() + triangleB.getSurfaceArea();
    }

    public static void displayAll(FunctionalArray<Triangle> triangles){
        for (Triangle triangle : triangles) {
            triangle.display();
        }
        System.out.println("------");
    }

    public static void main(String[] args) {
        FunctionalArray<Triangle> triangles = new FunctionalArray<>();
        
        double[] edges1 = {3,4,5};
        double[] edges2 = {6,8,10};
        double[] edges3 = {9,12,15};
        
        Triangle tri1 = new Triangle(edges1);
        Triangle tri2 = new Triangle(edges2);
        Triangle tri3 = new Triangle(edges3);

        triangles.add(tri1);
        triangles.add(tri2);
        triangles.add(tri3);

        TriangleFunctions.displayAll(triangles);

        ArrayList<Square> squares = triangles.map(TriangleFunctions::mapping);

        for (Square square : squares) {
            square.display();
        }
        
        System.out.println("------");
    }
}

