package main.java.br.edu.ifsp.Aulas.aula05.exFigures;

public final class Rectangle extends Figure {
    private final double width;
    private final double length;

    public Rectangle(double x, double y, double width, double length) {
        super(x, y);
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return width * length;
    }

    @Override
    public String toString() {
        return "main.java.br.edu.ifsp.Aulas.aula05.exFigures.Rectangle{" +
                "width=" + width +
                ", length=" + length +
                '}';
    }
}
