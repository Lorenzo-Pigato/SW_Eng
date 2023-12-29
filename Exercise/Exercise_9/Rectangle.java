package Exercise.Exercise_9;

public class Rectangle {
    private double width;
    private double height;
    private double perimeter;
    private double surfaceArea;

    public Rectangle (double width, double height){
        this.height = height;
        this.width = width;
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
    public Square (double edge) {
        super(edge, edge); 
    }
}
