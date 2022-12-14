package org.example;

import org.example.PageObject.OrderPages;
import org.example.PageObject.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import static org.hamcrest.CoreMatchers.startsWith;

@RunWith(Parameterized.class)
public class OrderTest {
    private final String name;
    private final String surname;
    private final String address;
    private final String phone;
    private final String station;
    private final String comment;


    public OrderTest(String name, String surname, String address, String phone, String station, String comment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.phone = phone;
        this.station = station;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static String[][] orderData() {
        return new String[][] {
                {"Игорь", "Булатов", "проспект Весёленьких", "888899546559", "Серпуховская", "В глаза не смотрите"},
                {"Северина", "Ким", "Гагарина 56", "89994905533", "Красные ворота", "-"}
        };
    }


    //Выбор браузера
    WebDriver driver = new ChromeDriver();
    //WebDriver driver = new FirefoxDriver();
    OrderPages objOrderPage = new OrderPages(driver);
    MainPage objMainPage = new MainPage(driver);

    @Before
   public void beforeTests() {
        // Переход на тестируемый сайт
        driver.get(objMainPage.url);
        // Ожидание прогрузки главной страницы
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // Соглашаемся на куки
        objMainPage.pushCookieButtonYes();
    }

    @Test
    public void OrderWithUpButton() {
        objOrderPage.pushUpOrder();

        objOrderPage.addNewName(name);
        objOrderPage.addNewSurname(surname);
        objOrderPage.addNewAddress(address);
        objOrderPage.addNewPhone(phone);
        objOrderPage.choiceMetro(station);
        objOrderPage.pushNext();
        //Вторая страница заказа
        objOrderPage.choiceDateStartRent();
        objOrderPage.choiceRentalPeriod();
        objOrderPage.pushBlack();
        objOrderPage.addNewComment(comment);
        objOrderPage.pushOrder();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        objOrderPage.pushYes();

        Assert.assertTrue(driver.findElement(objOrderPage.orderDone).isEnabled());
        String textOrderDone = driver.findElement(objOrderPage.orderDone).getText();
        Assert.assertThat("Заказ не оформлен", textOrderDone, startsWith("Заказ оформлен"));
    }

    @Test
    public void OrderWithMiddleButton(){
        objOrderPage.pushMiddleOrder();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        objOrderPage.addNewName(name);
        objOrderPage.addNewSurname(surname);
        objOrderPage.addNewAddress(address);
        objOrderPage.addNewPhone(phone);
        objOrderPage.choiceMetro(station);
        objOrderPage.pushNext();
        //Вторая страница заказа
        objOrderPage.choiceDateStartRent();
        objOrderPage.choiceRentalPeriod();
        objOrderPage.pushGrey();
        objOrderPage.addNewComment(comment);
        objOrderPage.pushOrder();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        objOrderPage.pushYes();

        Assert.assertTrue(driver.findElement(objOrderPage.orderDone).isEnabled());
        String textOrderDone = driver.findElement(objOrderPage.orderDone).getText();
        Assert.assertThat("Заказ не оформлен", textOrderDone, startsWith("Заказ оформлен"));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
