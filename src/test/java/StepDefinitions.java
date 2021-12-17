import base.BasePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StepDefinitions
{
    String expectedHomePageTitle = "Sky Glass - The New 4k TV From Sky | Sky Broadband, TV & Mobile | Sky.com";
    String expectedSignInPageTitle = "Sign in to your Sky account";

    String actualText;

    /**     Common steps --- Starts here       **/

    @Given("I am on the home page")
    public void i_am_on_the_home_page() throws InterruptedException {
        BasePage.navigateToUrl();
        Assert.assertEquals(expectedHomePageTitle, BasePage.getPageTitle());

        BasePage.homePage.handleCookies();
    }

    @When("I navigate to ‘Deals’")
    public void i_navigate_to_deals() throws InterruptedException
    {
        Thread.sleep(500);
        BasePage.homePage.clickDealsLink();
    }

    /**     Common steps --- Ends here       **/


    /**     Shop feature --- Starts here     **/

    @Then("the user should be on the deals {string} page")
    public void the_user_should_be_on_the_deals_page(String expectedDealsPageTitle)
    {
        Assert.assertEquals(expectedDealsPageTitle, BasePage.getPageTitle());
    }

    @Then("I see a list of deals with a price to it")
    public void i_see_a_list_of_deals_with_a_price_to_it()
    {
        System.out.println(BasePage.dealsPage.getTotalDealsDisplayed());
    }

    @Then("I see a list of deals with a price1 price2 price3 to it")
    public void i_see_a_list_of_deals_with_a_price1_price2_price3_to_it(io.cucumber.datatable.DataTable dataTable)
    {
        String dealPrice;

        for(int i=1; i<3; i++)
        {
            dealPrice = BasePage.dealsPage.getDealsPrice(i);
            Assert.assertTrue(dealPrice.contains(dataTable.cell(1,i-1)));
        }
    }

    /**     Shop feature --- Ends here     **/


    /**     Sign In feature --- Starts here     **/

    @When("I try to sign in with invalid credentials email or username {string}")
    public void i_try_to_sign_in_with_invalid_credentials_email_or_username(String username)
    {
        BasePage.homePage.clickSignInLink();
        Assert.assertEquals(expectedSignInPageTitle, BasePage.getPageTitle());

        BasePage.signInPage.login(username);
    }

    @Then("I should see a box with the text {string}")
    public void i_should_see_a_box_with_the_text(String expectedText) throws InterruptedException {
        String actualText = BasePage.signInPage.getActualText();
        Assert.assertEquals(expectedText, actualText);
    }

    /**     Sign In feature --- Ends here       **/



    /**     Editorial Feature --- Starts here     **/

    @When("I search {string} in the search bar")
    public void i_search_in_the_search_bar(String search) throws InterruptedException {
        BasePage.searchPage.clickSearchToggleIcon();
        BasePage.searchPage.enterSearchData(search);
    }

    @Then("I should see an editorial section {string}")
    public void i_should_see_an_editorial_section(String expectedEditorial)
    {
        String actualEditorial = BasePage.searchPage.getEditorialLinkText();

        Assert.assertEquals(expectedEditorial,actualEditorial);
    }

    /**     Editorial Feature --- Ends here       **/

}

