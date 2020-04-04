import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmForm {

    private WebDriver driver;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div/div/div/div[3]/div[1]/span")
    public WebElement inputCode;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div/div/div/div[3]/div[1]/div/button")
    public WebElement confirmButton;

    @FindBy(xpath = "/html/body/div[1]/div[5]/div/div/div/div[3]/div[2]/button")
    public WebElement cancelButton;

    public ConfirmForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /**
     * Ввести адрес
     * @param address - {@link Address}
     */

    public void inputCodeVoid(Address address) {
        inputCode.sendKeys(address.phoneNumber);
    }

    public void confirmButtonVoid() {
        confirmButton.click();
    }

    public void cancelButtonVoid() {
        cancelButton.click();
    }
}
