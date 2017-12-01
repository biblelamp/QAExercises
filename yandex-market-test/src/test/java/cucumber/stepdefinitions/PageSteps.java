package cucumber.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.Page;
import tools.DriverManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Steps for cucumber test for market.yandex.ru
 *
 * @author Sergey Irupin
 * @version 0.1 dated Dec 01, 2017
 */
public class PageSteps {
    private Page page;
    static WebDriver driver;
    static Map<String, String> sets;
    static List<WebElement> list;
    static String notebookName;

    // static initialization block
    static {
        System.setProperty("webdriver.gecko.driver", "C:\\Program Files\\Java\\geckodriver.exe");
        driver = DriverManager.getDriver();
        sets = new HashMap<String, String>();
        sets.put("HP", "glf-7893318-152722");
        sets.put("Lenovo", "glf-7893318-152981");
        sets.put("Apply", "//div[@class='n-filter-panel-aside__apply']//button[.='Применить']");
        sets.put("items", "//div[@class='n-snippet-card2__title']");
        sets.put("Search", "//span[@class='search2__button']//button[.='Найти']");
        sets.put("Name", "//div[@class='n-title__text']");
    }

    @Given("^user opens the site '(.+)'$")
    public void openPage(String url) {
        page = new Page(driver);
        page.load(url);
    }

    @And("^he goes to '(.+)'$")
    public void goSection(String linkText) {
        page.goByLinkText(linkText);
    }

    @And("^he sets up limit of prices '(.+)'$")
    public void setPriceToById(String price) {
        page.setPriceById("glf-priceto-var", price);
    }

    @And("^he chooses the brand '(.+)'$")
    public void chooseBrand(String brand) {
        page.selectCheckById(sets.get(brand));
    }

    @And("^he clicks '(.+)'$")
    public void clickButton(String button) {
        page.clickButtonByXpath(sets.get(button), 10);
    }

    @Then("^he should see '(.+)' '(.+)' per page$")
    public void checkCountItems(int count, String xpath) {
        list = driver.findElements(By.xpath(sets.get(xpath)));
        Assert.assertEquals(count, list.size());
    }

    @And("^he saves first items name$")
    public void saveFirstItem() {
        notebookName = list.get(0).getText();
    }

    @And("^he put saved name in the search line$")
    public void putTextInSearch() {
        page.enterSearchText(notebookName, "header-search");
    }

    @Then("^he takes '(.+)' and compares with saved$")
    public void compareWithSaved(String name) {
        WebElement title = driver.findElement(By.xpath(sets.get(name)));
        Assert.assertEquals(notebookName, title.getText());
    }
}