import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class OrderForm {

    private WebDriver driver;

    @FindBy(id = "addressFrom")
    public WebElement addressFrom;

    @FindBy(id = "addressTo")
    public WebElement addressTo;

    @FindBy(className = "button_action_demo")
    public WebElement demoButton;

    @FindBy(css = ".input__popup_fade_yes.popup")
    public WebElement popupList;

    @FindBy(xpath = "//div[text()=\"Определяем адрес\"]")
    public WebElement popupCheckAddress;

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
        addressFrom.sendKeys(address);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(popupList));
        Assert.assertNotNull(element);
        Assert.assertTrue(element.isDisplayed());
    }

    public void inputAddressTo(String address) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        addressTo.sendKeys(address);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(popupList));
        Assert.assertNotNull(element);
        Assert.assertTrue(element.isDisplayed());
    }

    public void inputPhoneNumber(String number) {
        phoneNumber.sendKeys(number);
    }

    public void submitButtonVoid() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.and(
                ExpectedConditions.visibilityOf(demoButton)));
        new Actions(driver).moveToElement(submitButton).click().perform();
    }

    public void clearButtonVoid() {
        clearButton.click();
    }

    public String errorMessageVoid() {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.visibilityOf(errorMessage));
        return element.getText();
    }

}