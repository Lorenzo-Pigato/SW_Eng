package Exercise.Exercise_4;

public class Rectangle extends Polygon {
    private int width;
    private int height;
    private int perimeter;

    public Rectangle(int width, int height){
        this.height = height;
        this.width = width;
    }

    @Override
    int getPerimeter() {
        perimeter = 2*(this.width + this.height); 
        return this.perimeter;
    }
}

class Square extends Rectangle {
    public Square (int edge) {
        super(edge, edge); 
    }
}
