package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage
{
    WebDriver driver;
    WebDriverWait wait;

    @FindBy (className = "search-toggle__icon")
    public WebElement searchToggleIcon;

    @FindBy (xpath = "//div/input[@data-test-id='input-box']")
    public WebElement searchData;

    @FindBy(linkText = "Help articles & guides (view all)")
    public WebElement editorialLink;



    public SearchPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickSearchToggleIcon()
    {
        searchToggleIcon.click();
    }

    public void enterSearchData(String search) throws InterruptedException
    {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(searchData));

        searchData.sendKeys(search);
    }

    public String getEditorialLinkText()
    {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(editorialLink));

        return editorialLink.getText();
    }

}
