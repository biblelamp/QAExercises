package com.pflb.learning.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager(){}

    public static WebDriver getDriver() {
        if (instance == null) {
            instance = new DriverManager();
            instance.driver = new FirefoxDriver(new FirefoxOptions().setLegacy(true));
        }
        return instance.driver;
    }
}
