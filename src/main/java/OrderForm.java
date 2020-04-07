import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OrderForm {

    private WebDriver driver;

    @FindBy(id = "addressFrom")
    public WebElement addressFrom;

    @FindBy(id = "addressTo")
    public WebElement addressTo;

    @FindBy(xpath = "/html/body/div[6]/div/ul/li[1]")
    public WebElement listFrom;

    @FindBy(xpath = "/html/body/div[8]/div/ul/li[1]")
    public WebElement listTo;

    @FindBy(id = "phoneNumber")
    public WebElement phoneNumber;

    @FindBy(css = "span.input__clear")
    public WebElement clearButton;

    @FindBy(className = "js-order-button")
    public WebElement submitButton;

    @FindBy(className = "popup_type_error")
    public WebElement errorMessage;


    public OrderForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputAddressFrom(String address){
        WebDriverWait wait = new WebDriverWait(driver, 5);
//        addressFrom.click();

        addressFrom.sendKeys(address);
//        wait.until(ExpectedConditions.visibilityOf(listFrom));
//        Select select = new Select(listFrom);
//        select.selectByIndex(0);
//        new Actions(driver).moveToElement(inputAddressFrom).perform();
       listFrom.click();
    }

    public void inputAddressTo(String address) {
        addressTo.sendKeys(address);
        listTo.click();
    }

    public void inputPhoneNumber(String number) {
        phoneNumber.sendKeys(number);
    }

    public void submitButtonVoid() {
        new Actions(driver).moveToElement(submitButton).perform();
        submitButton.click();
    }

    public void clearButtonVoid() {
        clearButton.click();
    }

    public String errorMessageVoid() {
        String errorMess = errorMessage.getText();
        return errorMess;
    }

}