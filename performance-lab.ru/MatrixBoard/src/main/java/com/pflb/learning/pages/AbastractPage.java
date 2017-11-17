package com.pflb.learning.pages;

import com.pflb.learning.helpers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Абстрактный класс, родитель всех Page'ей
 * Сделан для того, чтобы все Page'и наследовали конструктор и поле с драйвером
 */
public abstract class AbastractPage {
    protected WebDriver driver; //Поле, где будет храниться драйвер

    /**
     * Дефолтный конструктор. Тут сразу получаем драйвер для взаимодействия с ним
     * А так же инициализируем элементы на Page'ах, которые были заданы с помощью аннотаций @FindBy
     */
    public AbastractPage() {
        driver = DriverManager.getDriver();
        PageFactory.initElements(driver, this);
    }
}
