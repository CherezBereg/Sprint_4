package org.example.PageObject;

import org.openqa.selenium.*;

import static org.junit.Assert.assertTrue;

public class OrderPages {
    private WebDriver driver;
    // Кнопка "Заказать" в шапке главной страницы
    public final By orderUpButton = By.className("Button_Button__ra12g");
    // Кнопка "Заказать" в середине главной страницы
    private final By orderMiddleButton = By.xpath("//*[@id=\"root\"]/div/div[1]/div[4]/div[2]/div[5]/button");

    public void pushUpOrder() {
        driver.findElement(orderUpButton).click();
    }
    // Нажать на кнопку "Заказать" в середине страницы
    public void pushMiddleOrder() {
        WebElement middleButton = driver.findElement(orderMiddleButton);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", middleButton);
        driver.findElement(orderMiddleButton).click();
    }
    // Поле для ввода имени
    private final By inputName = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/input");
    // Поле для ввода фамилии
    private final By inputSurname = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/input");
    // Поле для указания адреса
    private final By inputAddress = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/input");
    // Поле для ввода номера телефона
    private final By inputPhoneNumber = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[5]/input");
    // Раскрывающийся список для выбора станции метро
    private final By selectMetro = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/div/div/input");
    // Кнопка "Далее"
    private final By nextButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button");

    public OrderPages(WebDriver driver) {
        this.driver = driver;
    }

    // Ввод имени
    public void addNewName (String newName) {
        assertTrue(driver.findElement(inputName).isEnabled());
        driver.findElement(inputName).clear();
        driver.findElement(inputName).sendKeys(newName);
    }

    // Ввод Фамилии
    public void addNewSurname (String newSurname) {
        assertTrue(driver.findElement(inputSurname).isEnabled());
        driver.findElement(inputSurname).clear();
        driver.findElement(inputSurname).sendKeys(newSurname);
    }

    // Ввод адреса
    public void addNewAddress (String newAddress) {
        assertTrue(driver.findElement(inputAddress).isEnabled());
        driver.findElement(inputAddress).clear();
        driver.findElement(inputAddress).sendKeys(newAddress);
    }

    // Ввод номера телефона
    public void addNewPhone (String newPhone) {
        assertTrue(driver.findElement(inputPhoneNumber).isEnabled());
        driver.findElement(inputPhoneNumber).clear();
        driver.findElement(inputPhoneNumber).sendKeys(newPhone);
    }

    // Клик по кнопке "Далее"
    public void pushNext () {
        assertTrue(driver.findElement(nextButton).isEnabled());
        driver.findElement(nextButton).click();
    }

    // Выбор метро
    public void choiceMetro(String station) {
        assertTrue(driver.findElement(selectMetro).isEnabled());
        driver.findElement(selectMetro).clear();
        driver.findElement(selectMetro).sendKeys(station, Keys.ARROW_DOWN, Keys.ENTER);
    }


    // Выбор даты аренды в формате всплывающего календаря
    private final By dateStartRent = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[1]/div[1]/div/input");
    // Поле с выбором срока аренды в формате всплывающего списка
    private final By rentalPeriod = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[2]/div/div[1]");
    // Список с возможной продолжительностью аренды, открывается после клика по rentalPeriod. (количество элементов - 7)
    // Выбирем 4 дня
    private final By rentalFourDays = By.xpath(".//div[contains(text(), 'четверо суток')]");
    // Чекбокс для выбора черного самоката
    private final By colourBlack = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/label[1]");
    // Чекбокс для выбора серого самоката
    private final By colourGrey = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[3]/label[2]");
    // Поле для ввода комментария для курьера
    private final By commentFromCourier = By.xpath("//*[@id=\"root\"]/div/div[2]/div[2]/div[4]/input");
    // Кнопка "Заказать", для подтверждения заказа после ввода данных
    private final By goOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[3]/button[2]");
    // Кнопка "Да" во всплывающем окне "Хотите оформить заказ?", активна после клика по goOrderButton
    private final By confirmationOrderButton = By.xpath("//*[@id=\"root\"]/div/div[2]/div[5]/div[2]/button[2]");
    // Всплывающее окно "Заказ оформлен"
    public final By orderDone = By.xpath(".//div[contains(text(),'Заказ оформлен')]");

    public void addNewComment(String newComment) {
        assertTrue(driver.findElement(commentFromCourier).isEnabled());
        driver.findElement(commentFromCourier).clear();
        driver.findElement(commentFromCourier).sendKeys(newComment);
    }

    // Выбор черного самоката
    public void pushBlack() {
        driver.findElement(colourBlack).click();
    }

    // Выбор серого самоката
    public void pushGrey() {
        driver.findElement(colourGrey).click();
    }

    // Клик по кнопке "Заказать" (нижней)
    public void pushOrder() {
        driver.findElement(goOrderButton).click();
    }
    // Клик по кнопке "Да"
    public void pushYes() {
        driver.findElement(confirmationOrderButton).click();
    }
    // Выбор продолжительности аренды
    public void choiceRentalPeriod() {
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalFourDays).click();
    }

    // Выбор даты начала аренды
    public void choiceDateStartRent() {
        driver.findElement(dateStartRent).click();
        driver.findElement(By.xpath(".//button[@aria-label='Next Month']")).click();
        driver.findElement(By.xpath(".//div[contains(@aria-label,'Choose')]")).click();
    }
}

