import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;


public class YandexTaxiTest {

    public static WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://taxi.yandex.ru/#index");
    }

    @After
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        driver.quit();
    }

    @Test
    public void inputAddressFromTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        OrderForm orderForm = new OrderForm(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        orderForm.clearButtonVoid();
        orderForm.submitButtonVoid();
        wait.until(ExpectedConditions.visibilityOf(orderForm.errorMessage));
        Assert.assertEquals("Пожалуйста, укажите адрес подачи такси", orderForm.errorMessageVoid());
    }

    @Test
    public void inputPhoneNumberTest() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 3);
        OrderForm orderForm = new OrderForm(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        orderForm.clearButtonVoid();
        orderForm.inputAddressFrom("проспект Ленина, 30");
        orderForm.submitButtonVoid();
        wait.until(ExpectedConditions.visibilityOf(orderForm.errorMessage));
        Assert.assertEquals("Ошибка в номере", orderForm.errorMessageVoid());
    }
}