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
 * @version 0.1 dated Nov 29, 2017
 */
public class Page {
    private WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    public void maximize() {
        driver.manage().window().maximize();
    }

    public void go(String[] steps) {
        driver.get(steps[0]);
        for (int i = 1; i < steps.length; i++) {
            List<WebElement> items = driver.findElements(By.linkText(steps[i]));
            for (WebElement item : items)
                try {
                    item.click();
                } catch (Exception ex) { }
        }
    }

    public void setPriceById(String id, String price) {
        driver.findElement(By.id(id)).click();
        driver.findElement(By.id(id)).clear();
        driver.findElement(By.id(id)).sendKeys(price);
    }

    public void selectCheckByXPathAndId(String xpath, String id) {
        driver.findElement(By.xpath(xpath)).click();
        if (!driver.findElement(By.id(id)).isSelected())
           driver.findElement(By.id(id)).click();
    }

    public void clickButtonByXpath(String xpath, int wait) {
        driver.findElement(By.xpath(xpath)).click();
        if (wait > 0)
            Tools.sleep(wait);
    }

    public void search(String name, String id, String xpath, int wait) {
        driver.findElement(By.id(id)).sendKeys(name);
        driver.findElement(By.xpath(xpath)).click();
        if (wait > 0)
            Tools.sleep(wait);
    }
}