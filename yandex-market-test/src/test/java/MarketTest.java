import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.DriverManager;
import tools.Tools;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Test class for market.yandex.ru
 *
 * @author Sergey Irupin
 * @version dated Nov 28, 2017
 */
public class MarketTest {
    static WebDriver driver;
    static WebDriverWait wait; // explicit wait

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    public static void quitDriver() {
        //DriverManager.getDriver().quit();
    }

    @Test
    public void laptopMarketTest() {
        driver.manage().window().maximize();
        driver.get("http://yandex.ru/");
        driver.findElement(By.linkText("Маркет")).click();
        driver.findElement(By.linkText("Компьютеры")).click();
        driver.findElement(By.linkText("Ноутбуки")).click();

        // extend parameters
        driver.findElement(By.id("glf-priceto-var")).click();
        driver.findElement(By.id("glf-priceto-var")).clear();
        driver.findElement(By.id("glf-priceto-var")).sendKeys("30000");
        driver.findElement(By.xpath("//label[@for='glf-7893318-152722']")).click();
        if (!driver.findElement(By.id("glf-7893318-152722")).isSelected()) {
            driver.findElement(By.id("glf-7893318-152722")).click();
        }
        driver.findElement(By.xpath("//label[@for='glf-7893318-152981']")).click();
        if (!driver.findElement(By.id("glf-7893318-152981")).isSelected()) {
            driver.findElement(By.id("glf-7893318-152981")).click();
        }
        driver.findElement(
                By.xpath("//div[@class='n-filter-panel-aside__apply']//button[.='Применить']")).click();
        Tools.sleep(10); // waiting

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='n-snippet-card2__title']"));
        String notebookName = list.get(0).getText();
        System.out.println(list.size());

        driver.findElement(By.id("header-search")).sendKeys(notebookName);
        driver.findElement(By.xpath("//span[@class='search2__button']//button[.='Найти']")).click();
        Tools.sleep(10); // waiting

        WebElement title = driver.findElement(By.xpath("//div[@class='n-title__text']"));
        Assert.assertEquals(notebookName, title.getText());
        //System.out.println(title.getText());
    }

    @Test
    public void tabletMarketTest() {
        //driver.manage().window().maximize();
        driver.get("http://yandex.ru/");
        driver.findElement(By.linkText("Маркет")).click();
        driver.findElement(By.linkText("Компьютеры")).click();
        driver.findElement(By.linkText("Планшеты")).click();

        // extend parameters
        driver.findElement(
                By.xpath("//div[@class='n-filter-panel-aside__content']//button[.='Показать всё']")).click();
        driver.findElement(By.xpath("//label[@for='glf-7893318-267101']")).click();
        if (!driver.findElement(By.id("glf-7893318-267101")).isSelected()) {
            driver.findElement(By.id("glf-7893318-267101")).click();
        }
        driver.findElement(By.xpath("//label[@for='glf-7893318-153080']")).click();
        if (!driver.findElement(By.id("glf-7893318-153080")).isSelected()) {
            driver.findElement(By.id("glf-7893318-153080")).click();
        }
        driver.findElement(By.id("glf-pricefrom-var")).click();
        driver.findElement(By.id("glf-pricefrom-var")).clear();
        driver.findElement(By.id("glf-pricefrom-var")).sendKeys("20000");
        driver.findElement(By.id("glf-priceto-var")).click();
        driver.findElement(By.id("glf-priceto-var")).clear();
        driver.findElement(By.id("glf-priceto-var")).sendKeys("25000");

        driver.findElement(
                By.xpath("//div[@class='n-filter-panel-aside__apply']//button[.='Применить']")).click();
        Tools.sleep(10); // waiting

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='n-snippet-card2__title']"));
        String tabletName = list.get(0).getText();
        System.out.println(list.size());

        driver.findElement(By.id("header-search")).sendKeys(tabletName);
        driver.findElement(By.xpath("//span[@class='search2__button']//button[.='Найти']")).click();
        Tools.sleep(10); // waiting

        WebElement title = driver.findElement(By.xpath("//div[@class='n-title__text']"));
        Assert.assertEquals(tabletName, title.getText());
        //System.out.println(title.getText());
    }
}