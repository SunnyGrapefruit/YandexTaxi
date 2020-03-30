import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderForm {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id=\"addressFrom\"]")
    public WebElement addressFrom;

    @FindBy(xpath = "//*[@id=\"addressTo\"]")
    public WebElement addressTo;

    @FindBy(xpath = "//*[@id=\"phoneNumber\"]")
    public WebElement phoneNumber;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[1]/div[2]/div[1]/div/div[1]/span/span[1]/span[2]")
    public WebElement clearButton;

    @FindBy(xpath = "/html/body/div[1]/div[4]/div[1]/div[1]/div[2]/div[6]/div[3]/button")
    public WebElement submitButton;

//    @FindBy(className = "popup_type_error")
//    public WebElement errorMessage;

    @FindBy(xpath = "/html/body/div[6]/div[2]")
    public WebElement errorMessage;

    public OrderForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Ввести адрес
     * @param address - {@link Address}
     */

    public void inputAddressFrom(Address address) {
        clearButton.click();
        addressFrom.sendKeys(address.addressFrom);
    }

    public void inputAddressTo(Address address) {
        addressTo.sendKeys(address.addressTo);
    }

    public void inputPhoneNumber(Address address) {
        phoneNumber.sendKeys(address.phoneNumber);
    }

    public void submitButton() {
        submitButton.click();
    }

    public OrderForm errorMessage(String errorMesse) {
        errorMessage.getText();
        return this;
    }

}