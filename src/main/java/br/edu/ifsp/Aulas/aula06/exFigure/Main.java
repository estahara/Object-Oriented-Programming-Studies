package main.java.br.edu.ifsp.Aulas.aula06.exFigure;

public class Main {
    static void main() {
        Figure c = new Circle(0,0,4);
        Figure r = new Rectangle(0,0,5,2);
        Figure t = new Triangle(0,0,2,3,5);

        System.out.println(c);
        System.out.println(r);
        System.out.println(t);

        Figure[] figures = new Figure[150];

        double x = 1;
        double areaTotal = 0;

        for (int i = 0; i < 50; i++) {
            Figure y = new Circle(0,0,x);
            figures[i] = y;
            x++;
            areaTotal += y.area();
        }

        x  = 1;
        for (int i = 50; i < 100; i++) {
            Figure y = new Rectangle(0,0,x,x);
            figures[i] = y;
            x++;
            areaTotal += y.area();
        }

        x = 1;
        for (int i = 100; i < 150; i++) {
            Figure y = new Triangle(0,0,x,x,x);
            figures[i] = y;
            x++;
            areaTotal += y.area();
        }

        System.out.printf("Area total = %f", areaTotal);

    }
}
