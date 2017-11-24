package tools;

/**
 * Java. Final task: homework
 * Utilities for calculation
 *
 * @author Sergey Iryupin
 * @version 0.1 dated Nov 24, 2017
 */
public class Utilities {

    final static String ERROR_DIVISIBLE = "Divisible isn't a number";
    final static String ERROR_DIVISOR = "Divisor isn't a number";

    /**
     * Calculate the result
     *
     * @param first     divisible in String
     * @param second    divisor in String
     * @return          result of division or error message
     */
    public static String calculate(String first, String second) {
        // check first operand
        if (!checkDouble(first))
            return ERROR_DIVISIBLE;
        // check second operand
        if (!checkDouble(second))
            return ERROR_DIVISOR;
        // calculate result
        double a = Double.parseDouble(first);
        double b = Double.parseDouble(second);
        double result = divide(a, b);
        return Double.toString(result);
    }

    /**
     * Checking the number
     *
     * @param str     double in String
     * @return true if the munber is valid
     */
    public static boolean checkDouble(String str) {
        try {
            double a = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }

    /**
     * Calculate the result of division
     *
     * @param a     divisible in Double
     * @param b     divisor in Double
     * @return result of division
     */
    public static double divide(double a, double b) {
        return a/b;
    }
}