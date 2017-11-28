package tools;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

/**
 * Driver manager (Singleton)
 *
 * @author Sergey Irupin
 * @version dated Nov 28, 2017
 */
public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager() {}

    public static WebDriver getDriver() {
        if (instance == null) {
            instance = new DriverManager();
            instance.driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        }
        return instance.driver;
    }
}