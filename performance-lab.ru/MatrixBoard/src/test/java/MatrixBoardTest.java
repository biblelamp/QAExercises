import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class MatrixBoardTest {
    WebDriver driver;   // ���� ��� �������� ������ ��������
    WebDriverWait wait; // ���� ��� ��������� ������ Explicit Wait

    public static final String USER_NAME = "user";
    public static final String PASSWORD = "user";

    @Before // ��������� Junit. �������, ��� ����� ������ ����������� ������ ��� ����� �������� ���������� ������, ����� ����� �������
    public void setUp() {
        // ������������� System Property, ����� ���� ��������� ������ ����� �������
        // ������� ��������� �� ������ https://github.com/mozilla/geckodriver/releases
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");

        // �������������� �������
        driver = new FirefoxDriver();

        // �������������� Implicit Wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // �������������� Explicit Wait
        wait = new WebDriverWait(driver, 10);
    }

    @After // ��������� Junit. �������, ��� ����� ������ ����������� ������ ��� ����� ���� ������
    public void tearDown() {
        driver.quit();
    }

    @Test // ��������� Junit. �������, ��� ���� ����� - ��������
    public void loginTest(){

        driver.navigate().to("http://at.pflb.ru/matrixboard2/"); // ������� �� URL

        // ������ � �������� ��������
        WebElement loginField = driver.findElement(By.id("login-username"));
        WebElement passwordField = driver.findElement(By.id("login-password"));
        WebElement submitBtn = driver.findElement(By.id("login-button"));

        // �������� ����
        loginField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);

        // �������� �����
        submitBtn.click();

        // � ������ �������� �� �����. ��������� � �������� ������� �������������
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#profile span"))); // ��������� ���� ������� �������� �� ��������
        wait.until((d) -> {return d.findElement(By.cssSelector("#profile span")).isDisplayed();}); // ������ ����������� ���������� ExpectedCondition. ���� ���� ��������� ������ ������ �� ������ ��� true (�� �� ������ ��������)

        WebElement usernameContainer = driver.findElement(By.cssSelector("#profile span")); // ������ �������
        Assert.assertEquals(USER_NAME, usernameContainer.getText()); // ��������, ��� ����� � ��������� �������� ��������� � ���������.
    }
}