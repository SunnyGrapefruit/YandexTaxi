import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

    @Test
    public void inputAddressFromTest() throws InterruptedException {
        OrderForm orderForm = new OrderForm(driver);
        orderForm.submitButton();
        TimeUnit.SECONDS.sleep(3);
        Assert.assertEquals("Пожалуйста, укажите адрес подачи такси", orderForm.errorMessage());
    }

    @Test
    public void inputPhoneNumberTest() throws InterruptedException {
        OrderForm orderForm = new OrderForm(driver);
        TimeUnit.SECONDS.sleep(3);
        orderForm.inputAddressFrom("проспект Ленина, 30");
        TimeUnit.SECONDS.sleep(3);
        orderForm.submitButton();
        TimeUnit.SECONDS.sleep(10);
        orderForm.submitButton();
        orderForm.submitButton();
        Assert.assertEquals("Ошибка в номере", orderForm.errorMessage());
    }

}