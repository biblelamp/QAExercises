package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import tools.Tools;

import java.util.List;

/**
 * Page class for testing pages
 *
 * @author Sergey Irupin
 * @version 0.2 dated Nov 29, 2017
 */
public class Page {
    private WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public Page maximize() {
        driver.manage().window().maximize();
        return this;
    }

    public Page load(String url) {
        driver.get(url);
        return this;
    }

    public Page goByLinkText(String linkText) {
        List<WebElement> items = driver.findElements(By.linkText(linkText));
        for (WebElement item : items)
            try {
                item.click();
            } catch (Exception ex) { }
        return this;
    }

    public Page setPriceById(String id, String price) {
        driver.findElement(By.id(id)).click();
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(price);
        return this;
    }

    public Page selectCheckById(String id) {
        driver.findElement(By.xpath("//label[@for='" + id + "']")).click();
        if (!driver.findElement(By.id(id)).isSelected())
           driver.findElement(By.id(id)).click();
        return this;
    }

    public Page clickButtonByXpath(String xpath, int wait) {
        driver.findElement(By.xpath(xpath)).click();
        if (wait > 0)
            Tools.sleep(wait);
        return this;
    }

    public Page search(String name, String id, String xpath, int wait) {
        driver.findElement(By.id(id)).sendKeys(name);
        driver.findElement(By.xpath(xpath)).click();
        if (wait > 0)
            Tools.sleep(wait);
        return this;
    }
}