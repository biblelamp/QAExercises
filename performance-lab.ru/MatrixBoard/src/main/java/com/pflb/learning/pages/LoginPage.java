package com.pflb.learning.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbastractPage {
    //@FindBy(id = "login-username") //Найти по id
    @FindBy(css = "#login-username") //найти по css
    private WebElement loginField;

    //@FindBy(id = "login-password")
    @FindBy(xpath = "//input[@id='login-password']") //найти по xpath
    private WebElement passwordField;

    @FindBy(id = "login-button")
    private WebElement submitBtn;

    //@FindBy(id = "login-failed")
    @FindBy(xpath = "//div[text() = 'Неправильный логин или пароль.']")
    private WebElement messageContainer;


    /**
     * Захардкодили урл сюда. Вообще стоил бы это вынести в файл конфигурации
     * или вообще сделать отдельный класс DataProvider, который нам будет возвращать тестовые данные.
     * Сначала, возможно, захардкодить, потом выбирать из базы данных ну и т.д.
     */
    private static final String url = "http://at.pflb.ru/matrixboard2/";

    /**
     * Метод загружает нашу страницу. Возможно, стоит вообще от метода избавиться,
     * а загрузку страницы вынести в конструктор.
     * return this (буквально: верни самого себя) сделан, чтобы в наших теста можно было комбинировать оперции в одну строку.
     */
    public LoginPage load(){
        driver.navigate().to(url);
        return this;
    }

// Вот пример такого конструктора
//    public LoginPage(){
//        super(); // вызовем конструктор родителя
//        driver.navigate().to(url); //и загрузим страницу
//    }

//ниже методы, которые ограничивают возможные варианты взаимодействия с нашими элементами

    public LoginPage fillLoginField(String text) {
        loginField.sendKeys(text);
        return this;
    }

    public LoginPage fillPasswordField(String text) {
        passwordField.sendKeys(text);
        return this;
    }

    public void submit() {
        submitBtn.click();
    }

    public boolean isErrorMessageVisible(){
        return messageContainer.isDisplayed();
    }
}
