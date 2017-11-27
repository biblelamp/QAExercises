package calc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tools.Utilities;

/**
 * Java. Final task: homework
 * Unit test for simple calculator (calculating)
 *
 * @author Sergey Iryupin
 * @version 0.1 dated Nov 27, 2017
 */
public class AppTestCalculation {
    private Utilities calc;

    @Before
    public void startTest() {
        calc = new Utilities();
    }

    @Test
    public void testCalcNormal() {
        Assert.assertEquals("2.5", calc.calculate("5", "2"));
    }

    @Test
    public void testCalcBadDivisible() {
        Assert.assertEquals(calc.ERROR_DIVISIBLE, calc.calculate("5-2", "2"));
    }

    @Test
    public void testCalcBadDivisor() {
        Assert.assertEquals(calc.ERROR_DIVISOR, calc.calculate("5", "2-5"));
    }
}