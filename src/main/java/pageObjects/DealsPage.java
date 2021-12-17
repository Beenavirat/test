package pageObjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DealsPage
{
    WebDriver driver;

    int totalDealsDisplayed;

    @FindBy(xpath = "(//div[@class='Background-xf35qs-0 dhyzdj'])")
    public WebElement deals;


    public DealsPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public int getTotalDealsDisplayed()
    {
        totalDealsDisplayed = driver.findElements(By.xpath("//div[@class='Background-xf35qs-0 dhyzdj']")).size();
        return totalDealsDisplayed;
    }

    public String getDealsPrice(int deal)
    {
        String dealPrice = driver.findElement(By.xpath("(//span[@class='text__Text-sc-1u9gciq-0 iNTDeb'])[" + deal + "]")).getText();

        return dealPrice;
    }



}


