import pageObject.MainPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;


@RunWith(Parameterized.class)
public class QuestionsListTest {

    //Выбор браузера
    WebDriver driver = new ChromeDriver();
    //WebDriver driver = new FirefoxDriver();
    MainPage objMainPage = new MainPage(driver);

    // Переменная для id ответа
     private final String answerLocator;
     // Переменная для id вопроса
    private final String questionLocator;
     // Переменная для ожидаемого текста
     private final String referenceText;

     // Конструктор класса
    public QuestionsListTest(String questionLocator, String answerLocator, String referenceText){
        this.questionLocator = questionLocator;
        this.answerLocator = answerLocator;
        this.referenceText = referenceText;
    }


    @Parameterized.Parameters
    public static Object[][] getData() {
        return new Object[][]{
                {"accordion__heading-0", "accordion__panel-0", Constants.ANSWER0},
                {"accordion__heading-1", "accordion__panel-1", Constants.ANSWER1},
                {"accordion__heading-2", "accordion__panel-2", Constants.ANSWER2},
                {"accordion__heading-3", "accordion__panel-3", Constants.ANSWER3},
                {"accordion__heading-4", "accordion__panel-4", Constants.ANSWER4},
                {"accordion__heading-5", "accordion__panel-5", Constants.ANSWER5},
                {"accordion__heading-6", "accordion__panel-6", Constants.ANSWER6},
                {"accordion__heading-7", "accordion__panel-7", Constants.ANSWER7},
        };
    }


    @Before
    public void beforeQuestionsTest() {
        // Переход на тестируемый сайт
        objMainPage.GoToTestingSite();
        // Ожидание прогрузки
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        // Соглашаемся на куки
        objMainPage.pushCookieButtonYes();
        // Скролим до вопросов
        objMainPage.scrollQuestions();
    }

    @Test
    public void answerTextTest(){
        driver.findElement(By.id(questionLocator)).click();
        String answerActualText = driver.findElement(By.id(answerLocator)).getText();
        Assert.assertEquals(referenceText, answerActualText);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
