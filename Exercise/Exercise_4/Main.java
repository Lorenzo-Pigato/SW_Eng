package Exercise.Exercise_4;

import java.util.ArrayList;
import java.util.List;
/*
 Deﬁnire una gerarchia di poligoni e sfruttare il poliformismo.
    
    👉  Polygon è una classe astratta che deﬁnisce il metodo astratto getPerimeter( ).
    
    👉  Polygon implementa una funzione printPerimeters( ) che stampi il perimetro
        di un array di poligoni.
    
    👉  Implementare le sotto-classi di Polygon Square, Rectangle e Triangle, ognuna
        con la propria implementazione di getPerimeter( )
 */

public class Main {
    public static void main(String[] args){
        Rectangle sqr = new Square(10);
        Rectangle rect = new Rectangle(10, 20);

        System.out.println(sqr.getPerimeter());
        System.out.println(rect.getPerimeter());

        int[] edg1 = {3,5,7};
        int[] edg2 = {3,4,9};
        int[] edg3 = {2,8,10};
        int[] edg4 = {2,8,10, 25};

        Triangle tri1 = new Triangle(edg1);
        Triangle tri2 = new Triangle(edg2);
        Triangle tri3 = new Triangle(edg3);

        try {
            Triangle tri4 = new Triangle(edg4);
            System.out.println(tri4.getPerimeter());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        List<Polygon> triangleList = new ArrayList<Polygon>();

        triangleList.add(tri1);
        triangleList.add(tri2);
        triangleList.add(tri3);

        Polygon.printPerimeters(triangleList);

    }
}
