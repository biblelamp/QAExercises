public class Square extends AbstractShape {
    public double side;

    public Square(double side) {
        super(ShapeType.SQUARE);
        this.side = side;
    }

    @Override
    public double getArea() {
        return side * side;
    }

    @Override
    public double getPerimeter() {
        return 4 * side;
    }
}
