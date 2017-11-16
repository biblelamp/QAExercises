import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

/**
 * Created by Sergej Irupin on 16.11.17.
 */
public class MatrixBoardAdminTest {
    WebDriver driver;
    WebDriverWait wait;

    static final String USER_NAME = "admin";
    static final String PASSWORD = "admin";

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");
        driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginTest() {

        driver.navigate().to("http://at.pflb.ru/matrixboard2/"); // перейти по URL

        WebElement loginField = driver.findElement(By.id("login-username"));
        WebElement passwordField = driver.findElement(By.id("login-password"));
        WebElement submitBtn = driver.findElement(By.id("login-button"));

        loginField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);
        submitBtn.click();

        WebElement adduserButton = driver.findElement(By.id("add-person"));

        if (adduserButton.isDisplayed() == true)
            System.out.println("I have admin privilege =)");
        else
            System.out.println("I do not have admin privilege =(");
    }
}