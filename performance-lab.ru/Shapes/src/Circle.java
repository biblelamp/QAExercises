import helpers.Point;

public class Circle extends AbstractShape {
    Point centerPoint;
    double radius;

    public Circle(Point centerPoint, double radius) {
        super(ShapeType.CIRCLE);
        this.centerPoint = centerPoint;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
