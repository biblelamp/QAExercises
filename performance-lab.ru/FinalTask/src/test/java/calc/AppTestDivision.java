package calc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tools.Utilities;

/**
 * Java. Final task: homework
 * Unit test for simple calculator (division)
 *
 * @author Sergey Iryupin
 * @version 0.2 dated Nov 27, 2017
 */
public class AppTestDivision {
    private Utilities calc;

    @Before
    public void startTest() {
        calc = new Utilities();
    }

    @Test
    public void testNormalDiv() {
        Assert.assertEquals(2.5, calc.divide(5, 2), 0);
    }

    @Test
    public void testDivZero() {
        Assert.assertEquals(0, calc.divide(0, 2), 0);
    }

    @Test
    public void testDivByZero() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, calc.divide(4, 0), 0);
    }

    @Test
    public void testDivZeroByZero() {
        Assert.assertEquals(Double.NaN, calc.divide(0, 0), 0);
    }
}