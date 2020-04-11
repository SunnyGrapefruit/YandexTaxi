import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmForm {

    private WebDriver driver;

//    @FindBy(className = "input_preset_code")
//    public WebElement inputCode;

    @FindBy(css = ".layout_view-name_auth .input__control")
    public WebElement inputCode;

//    @FindBy(xpath = "span.input__box")
//    public WebElement inputCode;

    @FindBy(className = "js-confirm-button")
    public WebElement confirmButton;

    @FindBy(className = "js-cancel-button")
    public WebElement cancelButton;

    @FindBy(className = "link__inner")
    public WebElement sendAgainButton;

    public ConfirmForm(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void inputCodeVoid(String code) {
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOf(inputCode));
//        new Actions(driver).moveToElement(inputCode).perform();
        inputCode.click();
        inputCode.sendKeys(code);
    }

    public void confirmButtonVoid() {
        confirmButton.click();
    }

    public void cancelButtonVoid() {
        cancelButton.click();
    }

    public void sendAgainVoid() {
        sendAgainButton.click();
    }

}
