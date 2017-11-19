package com.pflb.learning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbastractPage {
    @FindBy(css = "#profile span")
    WebElement usernameContainer;

    @FindBy(css = "#logout span")
    WebElement logoutBtn;

    public String getUsername() {
        return usernameContainer.getText();
    }

    public void logout() {
        logoutBtn.click();
    }
}
