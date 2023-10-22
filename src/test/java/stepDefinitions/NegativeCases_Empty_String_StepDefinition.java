package stepDefinitions;

import com.aventstack.extentreports.Status;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import utils.ErrorHandler;
import utils.ExtentReportManager;
import utils.TestBase;
import utils.TestContextSetup;

public class NegativeCases_Empty_String_StepDefinition extends TestBase{
SoftAssert sassert=new SoftAssert();
    public pageObjects.SearchPage searchPage;
    TestContextSetup testContextSetup;


    public NegativeCases_Empty_String_StepDefinition(TestContextSetup testContextSetup)
    {
        this.testContextSetup=testContextSetup;
        this.searchPage = testContextSetup.pageObjectManager.getSearchPage();
        test = ExtentReportManager.createTest("Search Google");
    }
    @Given("User is on Google search home page negative")
    public void user_is_on_Google_search_home_page() {

        extentTest.get().log(Status.PASS, "Step 1 executed successfully.");
    }
    @When("User searched with empty {string} input")
    public void User_searched_with_input(String companyName) throws ErrorHandler {
        try {
            searchPage.searchItem(companyName);
            test.log(Status.PASS, "Step 2 executed successfully.");
        }
        catch (Exception e) {
            // Handle or log the exception, and then re-throw it as a custom exception
            throw new ErrorHandler("An error occurred during the action.");
        }

    }
    @Then("User gets the incorrect result items in Google Search page")
    public void  validates_the_search_to_get_result() throws ErrorHandler {
        try {
            Boolean flag=searchPage.verifyFirstResultAfterSearchNegative();
            Assert.assertFalse(flag);
        }
        catch (Exception e) {

            throw new ErrorHandler("An error occurred during the action.");
        }

    sassert.assertAll();
    }


}
