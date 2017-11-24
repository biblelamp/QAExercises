public class Main {
    public final static double STEP = 0.1;

    public static void main(String[] args) {
        double s = integrate(new MathFunctionImpl(), 1, 10);
        System.out.println(s);
    }

    static double integrate(MathFunction function, int a, int b) {
        double result = 0;
        for (double currentX = a; currentX < b; currentX += STEP) {
            double currentValue = function.getValue(currentX);
            result += currentValue * 0.1;
        }
        return result;
    };
}

class MathFunctionImpl implements MathFunction {

    @Override
    public double getValue(double x) {
        return 1;
    }
}
