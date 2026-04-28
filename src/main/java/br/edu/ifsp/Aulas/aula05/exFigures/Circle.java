package main.java.br.edu.ifsp.Aulas.aula05.exFigures;

public final class Circle extends Figure{
    private final double radius;

    public Circle(double x, double y, double radius) {
        super(x, y);
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return "main.java.br.edu.ifsp.Aulas.aula05.exFigures.Circle{" +
                "radius=" + radius +
                '}';
    }
}
