package Exercise.Exercise_4;

import java.util.List;

abstract class Polygon {
    abstract int getPerimeter();

    public static void printPerimeters(List<Polygon> list){
        for (Polygon p: list) {
            System.out.println(p.getPerimeter());
        }
    }
}
