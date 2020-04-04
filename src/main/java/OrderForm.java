import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderForm {

    private WebDriver driver;

    @FindBy(id = "addressFrom")
    public WebElement addressFrom;

    @FindBy(id = "addressTo")
    public WebElement addressTo;

//    @FindBy(xpath = "//*[@id=\"addressTo\"]")
//    public WebElement addressTo;

    @FindBy(id = "phoneNumber")
    public WebElement phoneNumber;

    @FindBy(css = "span.input__clear")
    public WebElement clearButton;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[1]/div[2]/div[6]/div[3]/button")
    public WebElement submitButton;

    @FindBy(className = "popup_type_error")
    public WebElement errorMessage;


    public OrderForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    /**
//     * Ввести адрес
//     * @param address - {@link Address}
//     */

    public void inputAddressFrom(String address) {
       addressFrom.sendKeys(address);
    }

    public void inputAddressTo(String address) {
        addressTo.sendKeys(address);
    }

//    public void inputAddressTo() {
//        Address address = new Address();
//        addressTo.sendKeys(address.addressTo);
//    }

    public void inputPhoneNumber(String number) {
        phoneNumber.sendKeys(number);
    }

    public void submitButtonVoid() {
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