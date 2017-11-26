package calc;

/**
 * Java. Final task: homework
 * Unit test for simple calculator
 *
 * @author Sergey Iryupin
 * @version 0.1 dated Nov 26, 2017
 */
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import tools.Utilities;

public class AppTest {
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
    public void testDivByZero() {
        Assert.assertEquals(Double.POSITIVE_INFINITY, calc.divide(4, 0), 0);
    }
 
    @Test
    public void testDivNaN() {
        Assert.assertEquals(Double.NaN, calc.divide(0, 0), 0);
    }
}