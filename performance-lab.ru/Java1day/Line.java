import helpers.Point;

public class Line extends AbstractShape {
    Point startPoint;
    Point endPoint;

    public Line(Point startPoint, Point endPoint) {
        super(ShapeType.LINE);
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public boolean equalLength(Line line) {
        return getPerimeter() == line.getPerimeter();
    }

    @Override
    public double getArea() {
        return 0;
    }

    @Override
    public double getPerimeter() {
        return Math.sqrt(
            Math.pow(endPoint.x - startPoint.x, 2) +
            Math.pow(endPoint.y - startPoint.y, 2));
    }
}