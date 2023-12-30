package Exercise.Exercise_9B;

public class Triangle {
    private double[] edges;
    private double perimeter;
    private double area;

    public Triangle(double[] edges){
        if(edges.length != 3 || edges == null) 
            throw new IllegalArgumentException("There must be 3 edges");

        if((edges[0]+ edges[1] > edges[2]) && (edges[0]+ edges[2] > edges[1]) && (edges[1] + edges[2] > edges[0]))
            this.edges = edges; 
        else
            throw new IllegalArgumentException("These edges can't form a valid triangle");
    }

    public void display() {
        System.out.println("Edges: " + edges[0] + " " + edges[1] + " " + edges[2] + " ");
    }

    public double getPerimeter(){
        for (double edge : edges) {
            perimeter += edge;
        }

        return perimeter;
    }

    // Triangle surface area is calculated with Erone-Sarrus rule:
    // A = sqrt[s*(s-a)*(s-b)*(s-c)]
    // s is triangle's semiperimeter

    public double getSurfaceArea(){
        double s = this.getPerimeter()/2;
        
        area = Math.sqrt(s*(s-edges[0])*(s-edges[1])*(s-edges[2]));
        return area;
    }
}
