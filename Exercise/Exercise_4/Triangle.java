package Exercise.Exercise_4;

public class Triangle extends Polygon {
    private int[] edges;
    private int perimeter;

    public Triangle(int[] edges){
        if(edges.length != 3 || edges == null) throw new IllegalArgumentException("There must be 3 edges");

        this.edges = edges; 
    }

    @Override
    public int getPerimeter(){
        for (int edge : edges) {
            perimeter += edge;
        }

        return perimeter;
    }
}
