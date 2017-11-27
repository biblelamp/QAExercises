package calc;

import org.fest.swing.annotation.RunsInEDT;
import org.fest.swing.edt.GuiQuery;
import org.fest.swing.fixture.FrameFixture;
import org.fest.swing.junit.testcase.FestSwingJUnitTestCase;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;
import static org.fest.swing.edt.GuiActionRunner.execute;

/**
 * Java. Final task: homework
 * Unit test for simple calculator (GUI)
 * @see https://www.ibm.com/developerworks/ru/library/j-swingtest/
 *
 * @author Sergey Iryupin
 * @version 0.1 dated Nov 27, 2017
 */
public class TestGUI extends FestSwingJUnitTestCase {
    private FrameFixture calculator;

    @Override
    protected void onSetUp() {
        calculator = new FrameFixture(robot(), createNewApp());
        calculator.show();
    }

    @RunsInEDT
    private static App createNewApp() {
        return execute(new GuiQuery<App>() {
            protected App executeInEDT() throws Throwable {
                return new App();
            }
        });
    }

    @Test
    public void testCalculateNormal() {
        calculator.textBox("firstNum").enterText("5");
        calculator.textBox("secondNum").enterText("2");
        calculator.button("calc").click();
        assertThat(calculator.textBox("resultNum").text()).contains("2.5");
    }

    @Test
    public void testDivideByZero() {
        calculator.textBox("firstNum").enterText("5");
        calculator.textBox("secondNum").enterText("0");
        calculator.button("calc").click();
        assertThat(calculator.textBox("resultNum").text()).contains("Infinity");
    }

    @Test
    public void testDivideZero() {
        calculator.textBox("firstNum").enterText("0");
        calculator.textBox("secondNum").enterText("5");
        calculator.button("calc").click();
        assertThat(calculator.textBox("resultNum").text()).contains("0.0");
    }

    @Test
    public void testDivideZeroByZero() {
        calculator.textBox("firstNum").enterText("0");
        calculator.textBox("secondNum").enterText("0");
        calculator.button("calc").click();
        assertThat(calculator.textBox("resultNum").text()).contains("NaN");
    }
}