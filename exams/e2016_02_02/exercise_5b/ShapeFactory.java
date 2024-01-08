package exams.e2016_02_02.exercise_5b;

import java.util.Scanner;

public class ShapeFactory {
    public Shape build(String shape){
        return (shape.equalsIgnoreCase("rectangle") ? new Rectangle() : new Circle());
    }  
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose a shape - rectangle or circle: ");
        
        new ShapeFactory().build(scanner.next()).draw();
        scanner.close();
    }
}
