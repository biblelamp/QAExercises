import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.Page;
import tools.DriverManager;
import tools.Tools;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Test class for market.yandex.ru
 *
 * @author Sergey Irupin
 * @version 0.2 dated Nov 29, 2017
 */
public class MarketTest {
    static WebDriver driver;
    static WebDriverWait wait; // explicit wait

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");
        driver = DriverManager.getDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 60);
    }

    @AfterClass
    public static void quitDriver() {
        //DriverManager.getDriver().quit();
    }

    @Test
    public void laptopMarketTest() {
        Page pageNotebooks = new Page(driver);
        pageNotebooks.maximize();
        pageNotebooks.go(new String[]{"http://yandex.ru/", "Маркет", "Компьютеры", "Ноутбуки"});

        pageNotebooks.setPriceById("glf-priceto-var", "30000");
        pageNotebooks.selectCheckByXPathAndId("//label[@for='glf-7893318-152722']", "glf-7893318-152722");
        pageNotebooks.selectCheckByXPathAndId("//label[@for='glf-7893318-152981']", "glf-7893318-152722");
        pageNotebooks.clickButtonByXpath(
                "//div[@class='n-filter-panel-aside__apply']//button[.='Применить']", 10);

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='n-snippet-card2__title']"));
        String notebookName = list.get(0).getText();
        System.out.println(list.size());

        pageNotebooks.search(
                notebookName, "header-search", "//span[@class='search2__button']//button[.='Найти']", 10);

        WebElement title = driver.findElement(By.xpath("//div[@class='n-title__text']"));
        Assert.assertEquals(notebookName, title.getText());
        //System.out.println(title.getText());
    }

    @Test
    public void tabletMarketTest() {
        Page pageTablet = new Page(driver);
        pageTablet.maximize();
        pageTablet.go(new String[]{"http://yandex.ru/", "Маркет", "Компьютеры", "Планшеты"});

        pageTablet.clickButtonByXpath(
                "//div[@class='n-filter-panel-aside__content']//button[.='Показать всё']", 0);
        pageTablet.selectCheckByXPathAndId("//label[@for='glf-7893318-267101']", "glf-7893318-267101");
        pageTablet.selectCheckByXPathAndId("//label[@for='glf-7893318-153080']", "glf-7893318-153080");
        pageTablet.setPriceById("glf-pricefrom-var", "20000");
        pageTablet.setPriceById("glf-priceto-var", "25000");
        pageTablet.clickButtonByXpath(
                "//div[@class='n-filter-panel-aside__apply']//button[.='Применить']", 10);

        List<WebElement> list = driver.findElements(By.xpath("//div[@class='n-snippet-card2__title']"));
        String tabletName = list.get(0).getText();
        System.out.println(list.size());

        pageTablet.search(
                tabletName, "header-search", "//span[@class='search2__button']//button[.='Найти']", 10);

        WebElement title = driver.findElement(By.xpath("//div[@class='n-title__text']"));
        Assert.assertEquals(tabletName, title.getText());
        //System.out.println(title.getText());
    }
}