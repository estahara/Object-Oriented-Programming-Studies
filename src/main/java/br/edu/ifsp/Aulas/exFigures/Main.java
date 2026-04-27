public class Main {
    public static void main(String[] args) {
        Circle circulo = new Circle(0,0,2);
        Rectangle retangulo = new Rectangle(0,0,2,5);
        Triangle triangulo = new Triangle(0,0,10,10,12);

        System.out.println(circulo);
        System.out.println(retangulo);
        System.out.println(triangulo);

        System.out.println("-------------------------------");
        System.out.println(circulo.area());
    }
}
