package Exercise.Exercise_9B;

public class Rectangle {
    private double width;
    private double height;
    private double perimeter;
    private double surfaceArea;

    public Rectangle (double width, double height){
        this.height = height;
        this.width = width;
    }
    
    public void display(){
        System.out.println("Width: " + width + "\tHeight: " + height);
    }

    double getPerimeter() {
        perimeter = 2*(this.width + this.height); 
        return this.perimeter;
    }
    
    double getSurfaceArea(){
        surfaceArea = width * height;
        return surfaceArea;
    }

}

class Square extends Rectangle {
    private double edge;
    public Square (double edge) {
        super(edge, edge); 
        this.edge = edge;
    }

    @Override
    public void display(){
        System.out.println("Edge: " + edge);
    }
}
