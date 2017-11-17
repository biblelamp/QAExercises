package com.pflb.learning.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    private static DriverManager instance;
    private WebDriver driver;

    private DriverManager(){}

    public static WebDriver getDriver() {
        if (instance == null) {
            instance = new DriverManager();
            instance.driver = new FirefoxDriver();
        }
        return instance.driver;
    }
}
