package main.java.br.edu.ifsp.Aulas.aula06.exFigure;

public final class Circle extends Figure {
    private double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * (Math.pow(radius, 2));
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return super.toString() + ", radius=" + getRadius() + "}";
    }
}
