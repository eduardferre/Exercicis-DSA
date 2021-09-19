public class Triangle extends Figura {
    private double h;
    private double b;

    public Triangle(double h, double b) {
        this.h = h;
        this.b = b;
    }

    public double area() {
        return h * b * 0.5;
    }
}
