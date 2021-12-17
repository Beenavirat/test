package base;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.DealsPage;
import pageObjects.HomePage;
import pageObjects.SearchPage;
import pageObjects.SignInPage;

public class BasePage {
    public static WebDriver driver;

    static String url = "https://www.sky.com/";

    public static HomePage homePage;
    public static SearchPage searchPage;
    public static SignInPage signInPage;
    public static DealsPage dealsPage;


    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.manage().window().maximize();

        homePage = new HomePage(driver);
        searchPage = new SearchPage(driver);
        signInPage = new SignInPage(driver);
        dealsPage = new DealsPage(driver);
    }

    @After
    public void closeUp(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "errorScreenshot");
        }

        driver.quit();

    }


    public static void navigateToUrl() {
        driver.navigate().to(url);
    }

    public static String getPageTitle() {
        return driver.getTitle();
    }

}
