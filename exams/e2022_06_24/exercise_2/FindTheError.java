package exams.e2022_06_24.exercise_2;

public class FindTheError {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Point px = new Point1D(0);
        Point1D py = new Point1D(0);
        Point2D pz = new Point2D(0, 0);
        px = py;
        px = pz; // 2
        // py = px; -- implicit conversion to subclass is not allowed
        py = pz;
        // pz = py; -- implicit conversion to subclass is not allowed

        Point p1 = new Point1D(0.0);
        Point p2 = new Point1D(1.0);
        Point p3 = new Point2D(0.0, 1.0);
        Point p4 = new Point2D(1.0, 0.0);
        double x;
        x = p1.distance(p2); // 1
        System.out.println(x);
        x = p3.distance(p4); // 2
        System.out.println(x);
        x = p1.distance(p3); // 3
        System.out.println(x);
        x = p1.distance(p1); // 4
        System.out.println(x);
        p1 = p3; // 5
        x = p2.distance(p3);
        System.out.println(x);
        x = p4.distance(p1); // 6
        System.out.println(x);
    }
}

abstract class Point {
    public abstract double distance(Point p);
}

class Point1D extends Point {
    private double c1;

    public Point1D(double c1) {
        this.c1 = c1;
    }

    public double getC1() {
        return c1;
    }

    public double distance(Point p) {
        return Math.abs(((Point1D) p).getC1() - c1);
    }
}

class Point2D extends Point1D {
    private double c2;

    public Point2D(double c1, double c2) {
        super(c1);
        this.c2 = c2;
    }

    public double getC2() {
        return c2;
    }

    public double distance(Point p) {
        return Math.sqrt(Math.pow(((Point2D) p).getC1() - this.getC1(), 2) +
                Math.pow(((Point2D) p).getC2() - this.getC2(), 2));
    }

    public double distance(Point2D p) {
        return Math.sqrt(Math.pow(p.getC1() - this.getC1(), 2) +
                Math.pow(p.getC2() - this.getC2(), 2));
    }
}