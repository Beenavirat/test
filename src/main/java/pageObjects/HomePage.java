package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{
    WebDriver driver;

    @FindBy (linkText = "Deals")
    public WebElement dealsLink;

    @FindBy(id="sp_message_iframe_474555")
    public WebElement cookieFrame;

    @FindBy (xpath = "//div/button[@title='Agree']")
    public WebElement cookiesAgreeButton;

    @FindBy (linkText = "Sign in")
    public WebElement signInLink;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void handleCookies() throws InterruptedException {
        driver.switchTo().frame(cookieFrame);
        Thread.sleep(1000);
        cookiesAgreeButton.click();
        driver.manage().deleteAllCookies();
        driver.switchTo().defaultContent();
    }

    public void clickDealsLink()
    {
        dealsLink.click();
    }

    public void clickSignInLink()
    {
        signInLink.click();
    }


}

