package org.example.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;
    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    public final String url = "https://qa-scooter.praktikum-services.ru/";
    // Кнопка, убирающая запрос на куки
    private final By cookieButtonYes = By.xpath("//*[@id=\"rcc-confirm-button\"]");
    // Аккордеон с вопросами
    private final By accordionQuestions = By.xpath("//*[@id=\"root\"]/div/div/div[5]/div[2]/div");

    // Скролим до вопросов
    public void scrollQuestions() {
        WebElement accordion = driver.findElement(accordionQuestions);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", accordion);
    }
    // Соглашаемся на куки
    public void pushCookieButtonYes(){
        driver.findElement(cookieButtonYes).click();
    }
}
