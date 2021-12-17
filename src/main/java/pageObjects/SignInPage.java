package pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage
{
    WebDriver driver;

    @FindBy (xpath = "//div/input[@id='username']")
    public WebElement userNameTextbox;

    @FindBy (css = "iframe[title='iFrame containing Sky Sign-In application'")
    public WebElement loginFrame;

    @FindBy (xpath = "//button[@data-testid='AUTHN__SUBMIT_BTN']")
    public WebElement continueButton;

    @FindBy (xpath = "//div[text()='Create your My Sky password']")
    public WebElement textCreateYourPassword;

    public SignInPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void login(String username)
    {
        driver.switchTo().frame(loginFrame);

        userNameTextbox.sendKeys(username);
        continueButton.click();

    }

    public String getActualText() throws InterruptedException {

        Thread.sleep(1000);

        String actualText = textCreateYourPassword.getText();
        return actualText;
    }
}
