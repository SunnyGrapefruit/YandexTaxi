import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Instant;
import java.util.concurrent.TimeUnit;


public class YandexTaxiTest {

    public static WebDriver driver;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "config\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://taxi.yandex.ru/#index");
    }

    @After
    public void tearDown() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        driver.quit();
    }

    @Test
    public void EmptyAddressFromTest() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        OrderForm orderForm = new OrderForm(driver);
//        orderForm.clearButtonVoid();
        orderForm.submitButtonVoid();
        wait.until(ExpectedConditions.visibilityOf(orderForm.errorMessage));
        Assert.assertEquals("Пожалуйста, укажите адрес подачи такси", orderForm.errorMessageVoid());
    }

    @Test
    public void EmptyPhoneNumberTest(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        OrderForm orderForm = new OrderForm(driver);
//        orderForm.clearButtonVoid();
        orderForm.inputAddressFrom("проспект Ленина, 33");
        orderForm.submitButtonVoid();
        wait.until(ExpectedConditions.visibilityOf(orderForm.errorMessage));
        Assert.assertEquals("Ошибка в номере", orderForm.errorMessageVoid());
    }

    @Test
    public void UncorrectPhoneNumberTest(){
        WebDriverWait wait = new WebDriverWait(driver, 5);
        OrderForm orderForm = new OrderForm(driver);
//        orderForm.clearButtonVoid();
        orderForm.inputAddressFrom("проспект Ленина, 30");
        orderForm.inputPhoneNumber("+19099435267");
        orderForm.submitButtonVoid();
        wait.until(ExpectedConditions.visibilityOf(orderForm.errorMessage));
        Assert.assertEquals("Сервис недоступен для Вашего региона. Укажите другой номер.", orderForm.errorMessageVoid());
    }

    @Test
    public void CorrectTestFrom() throws InterruptedException {
        OrderForm orderForm = new OrderForm(driver);
//        orderForm.clearButtonVoid();
        orderForm.inputAddressFrom("проспект Ленина, 30");
        orderForm.inputPhoneNumber("+79999435267");
        orderForm.submitButtonVoid();
        TimeUnit.SECONDS.sleep(3);
    }

    @Test
    public void correctTestFromTo(){
        OrderForm orderForm = new OrderForm(driver);
//        orderForm.clearButtonVoid();
        orderForm.inputAddressFrom("проспект Ленина, 30");
        orderForm.inputAddressTo("проспект Мира, 30");
        orderForm.inputPhoneNumber("+79999435267");
        orderForm.submitButtonVoid();
    }

    @Test
    public void correctTestTo() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        OrderForm orderForm = new OrderForm(driver);
//        orderForm.clearButtonVoid();
        orderForm.inputAddressTo("проспект Мира, 30");
        orderForm.submitButtonVoid();
        wait.until(ExpectedConditions.visibilityOf(orderForm.errorMessage));
        Assert.assertEquals("Пожалуйста, укажите адрес подачи такси", orderForm.errorMessageVoid());
    }

    @Test  //org.openqa.selenium.ElementNotInteractableException: element not interactable
    public void correctCodeInput() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        CorrectTestFrom();
        OrderForm orderForm = new OrderForm(driver);

//        wait.until(ExpectedConditions.visibilityOf(orderForm.block));
        new Actions(driver).moveToElement(orderForm.inputCode).click();
//        new Actions(driver).moveToElement(orderForm.inputHoveredCode).click();
//        new Actions(driver).moveToElement(orderForm.inputFocusCode).perform();
//        new Actions(driver).moveToElement(orderForm.block).perform();
//        orderForm.inputCode.click();

        orderForm.inputCode.sendKeys("256");

//        confirmForm.inputCodeVoid("123");
//        confirmForm.confirmButtonVoid();
    }

    @Test
    public void cancelOrder() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        CorrectTestFrom();
        ConfirmForm confirmForm = new ConfirmForm(driver);
        OrderForm orderForm = new OrderForm(driver);
        confirmForm.cancelButtonVoid();
        wait.until(ExpectedConditions.visibilityOf(orderForm.addressFrom));
    }
}