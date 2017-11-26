package tools;

/**
 * Java. Final task: homework
 * Utilities for calculation
 *
 * @author Sergey Iryupin
 * @version 0.2 dated Nov 26, 2017
 */
public class Utilities {

    final String ERROR_DIVISIBLE = "Divisible isn't a number";
    final String ERROR_DIVISOR = "Divisor isn't a number";

    /**
     * Calculate the result
     *
     * @param  first     divisible in String
     * @param  second    divisor in String
     * @return result of division or error message
     */
    public String calculate(String first, String second) {
        // fix problem with ","
        first = first.replaceAll(",", ".");
        second = second.replaceAll(",", ".");
        Double a = getDouble(first); // get first operand
        if (a.equals(Double.NaN))
            return ERROR_DIVISIBLE;
        Double b = getDouble(second); // get second operand
        if (b.equals(Double.NaN))
            return ERROR_DIVISOR;
        // calculate and return the result
        return Double.toString(a / b);
    }

    /**
     * Get Double from String
     *
     * @param  str     double in String
     * @return Double if the nunber is valid or Double.NaN if not
     */
    public Double getDouble(String str) {
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException ex) {
            return Double.NaN;
        }
    }

    /**
     * Calculate the result of division
     *
     * @param  a     divisible in Double
     * @param  b     divisor in Double
     * @return result of division
     */
    public double divide(double a, double b) {
        return a / b;
    }
}