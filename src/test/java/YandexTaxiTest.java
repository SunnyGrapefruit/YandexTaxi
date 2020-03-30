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
    }

    @Test
    public void inputAddressFromTest() throws InterruptedException {
        driver.get("https://taxi.yandex.ru/#index");
        OrderForm orderForm = new OrderForm(driver);
        orderForm.submitButton();
        TimeUnit.SECONDS.sleep(3);
        Assert.assertEquals("Пожалуйста, укажите адрес подачи такси", orderForm.errorMessage());
    }

//    public void inputPhoneNumberTest() throws InterruptedException {
//        driver.get("https://taxi.yandex.ru/#index");
//        OrderForm orderForm = new OrderForm(driver);
//        Address address = Address.createValidAddress();
//        address.OrderForm.inputAddressFrom();
//        TimeUnit.SECONDS.sleep(3);
//        Assert.assertEquals("Ошибка в номере", orderForm.errorMessage());
//    }
}