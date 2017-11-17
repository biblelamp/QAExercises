package com.pflb.learning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbastractPage {
    @FindBy(css = "#profile span")
    WebElement usernameContainer;

    public String getUsername() {
        return usernameContainer.getText();
    }
}
