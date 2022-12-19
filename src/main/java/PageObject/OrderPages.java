package pageObject;

import org.openqa.selenium.*;

import static org.junit.Assert.assertTrue;

public class OrderPages {
    private WebDriver driver;
    // Поле для ввода имени
    private final By inputName = By.xpath(".//input[@placeholder='* Имя']");
    // Поле для ввода фамилии
    private final By inputSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    // Поле для указания адреса
    private final By inputAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле для ввода номера телефона
    private final By inputPhoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Раскрывающийся список для выбора станции метро
    private final By selectMetro = By.xpath(".//input[@placeholder='* Станция метро']");
    // Кнопка "Далее"
    private final By nextButton = By.xpath("//button[text()='Далее']");
    // Выбор даты аренды в формате всплывающего календаря
    private final By dateStartRent = By.xpath(".//div[@class='react-datepicker__input-container']/input");
    // Выбор месяца
    private final By choiceMonth = By.xpath(".//button[@aria-label='Next Month']");
    // Выбор дня
    private final By choiceDay = By.xpath(".//div[contains(@aria-label,'Choose')]");
    // Поле с выбором срока аренды в формате всплывающего списка
    private final By rentalPeriod = By.className("Dropdown-placeholder");
    // Список с возможной продолжительностью аренды, открывается после клика по rentalPeriod. (количество элементов - 7)
    // Выбирем 4 дня
    private final By rentalFourDays = By.xpath(".//div[contains(text(), 'четверо суток')]");
    // Чекбокс для выбора черного самоката
    private final By colourBlack = By.id("black");
    // Чекбокс для выбора серого самоката
    private final By colourGrey = By.id("grey");
    // Поле для ввода комментария для курьера
    private final By commentFromCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать", для подтверждения заказа после ввода данных
    private final By goOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    // Кнопка "Да" во всплывающем окне "Хотите оформить заказ?", активна после клика по goOrderButton
    private final By confirmationOrderButton = By.xpath(".//button[contains(text(),'Да')]");
    // Всплывающее окно "Заказ оформлен"
    public final By orderDone = By.xpath(".//div[contains(text(),'Заказ оформлен')]");

    public OrderPages(WebDriver driver) {
        this.driver = driver;
    }

    // Ввод имени
    public void addNewName (String newName) {
        assertTrue(driver.findElement(inputName).isEnabled());
        driver.findElement(inputName).clear();
        driver.findElement(inputName).sendKeys(newName);
    }

    // Ввод фамилии
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

    // Добавляем коментарий для курьера
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
        driver.findElement(choiceMonth).click();
        driver.findElement(choiceDay).click();
    }
}

