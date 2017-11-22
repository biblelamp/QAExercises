import helpers.Point;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle(new Point(1,2), 5.2);
        Square square = new Square(6);
        Line line1 = new Line(new Point(1, 1), new Point(2, 2));
        Line line2 = new Line(new Point(-3, 0), new Point(1, 1));

        AbstractShape[] shapes = {circle, square, line1, line2};
        for (AbstractShape shape : shapes) {
            System.out.println(shape);
        }
        
        if (line1.equalLength(line2))
            System.out.println("Длины отрезков равны.");
    }
}