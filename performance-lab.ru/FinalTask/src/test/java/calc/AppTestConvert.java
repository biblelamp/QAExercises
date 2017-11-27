package calc;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tools.Utilities;

/**
 * Java. Final task: homework
 * Unit test for simple calculator (conversion)
 *
 * @author Sergey Iryupin
 * @version 0.1 dated Nov 27, 2017
 */
public class AppTestConvert {
    private Utilities calc;

    @Before
    public void startTest() {
        calc = new Utilities();
    }

    @Test
    public void testStrToDoublePositiveWithDot() {
        Assert.assertEquals(Double.valueOf(13.5), calc.getDouble("13.5"));
    }

    @Test
    public void testStrToDoublePositiveWithComma() {
        Assert.assertEquals(Double.valueOf(12.4), calc.getDouble("12,4"));
    }

    @Test
    public void testStrToDoubleNegative() {
        Assert.assertEquals(Double.NaN, calc.getDouble("12:4"), 0);
    }
}