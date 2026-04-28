package main.java.br.edu.ifsp.Aulas.aula06.exFigure;

public final class Rectangle extends Figure{
    private double width;
    private double length;

    public Rectangle(double x, double y, double width, double length) {
        super(x, y);
        this.width = width;
        this.length = length;
    }

    @Override
    public double area() {
        return width * length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return super.toString() + ", width=" + getWidth() + ", length=" + getLength() + "}";
    }
}
