import helpers.Point;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle(new Point(1,2), 5.2);
        Circle circle2 = new Circle(new Point(2,3), 3);
        Square square1 = new Square(6);
        Square square2 = new Square(8);

        AbstractShape[] shapes = {circle1, circle2, square1, square2};
        for (AbstractShape shape : shapes) {
            System.out.println(shape);
        }
    }
}
