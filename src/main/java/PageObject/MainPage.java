package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class MainPage {
    private WebDriver driver;
    public MainPage (WebDriver driver) {
        this.driver = driver;
    }

    public static final String URL = "https://qa-scooter.praktikum-services.ru/";
    // Кнопка, убирающая запрос на куки
    private final By cookieButtonYes = By.id("rcc-confirm-button");
    // Аккордеон с вопросами
    private final By accordionQuestions = By.className("accordion");
    // Кнопка "Заказать" в шапке главной страницы
    public final By orderUpButton = By.xpath(".//div[contains(@class,'Header_Nav')]/button[@class='Button_Button__ra12g']");
    // Кнопка "Заказать" в середине главной страницы
    private final By orderMiddleButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    public void pushUpOrder() {
        driver.findElement(orderUpButton).click();
    }
    // Нажать на кнопку "Заказать" в середине страницы
    public void pushMiddleOrder() {
        WebElement middleButton = driver.findElement(orderMiddleButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", middleButton);
        driver.findElement(orderMiddleButton).click();
    }

    // Скролим до вопросов
    public void scrollQuestions() {
        WebElement accordion = driver.findElement(accordionQuestions);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", accordion);
    }
    // Соглашаемся на куки
    public void pushCookieButtonYes(){
        driver.findElement(cookieButtonYes).click();
    }
    //Переход на тестируемый сайт
    public void GoToTestingSite() {
        driver.get(URL);
    }
}
