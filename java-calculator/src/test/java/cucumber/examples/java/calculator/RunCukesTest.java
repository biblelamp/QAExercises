package cucumber.examples.java.calculator;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
        tags = "@all",
        features = "src/test/resources/cucumber/examples/java/calculator",
        plugin = "json:target/cucumber-report.json")
public class RunCukesTest {
}
