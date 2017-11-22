public abstract class AbstractShape implements Geom {
    private ShapeType type;

    public AbstractShape(ShapeType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return String.format("Фигура: %s\nплощадь: %f\nПериметр: %f\n\n", type, getArea(), getPerimeter());
    }
}
