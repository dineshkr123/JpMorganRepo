package stepDefinitions;

import com.aventstack.extentreports.Status;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.*;

public class LandingPageStepDefinition extends TestBase {
TestContextSetup testContextSetup;
LandingPage landingPage;

public LandingPageStepDefinition(TestContextSetup testContextSetup)
{
	this.testContextSetup=testContextSetup;
	this.landingPage =testContextSetup.pageObjectManager.getLandingPage();
	test = ExtentReportManager.createTest("Verify Logo");
}
	@Given("User is on JpMorgan HomePage")
       public void user_is_on_landing_page() {

	        System.out.println("In given");
    }

	@When("The user verifies the Logo of Jpmorgan")
	public void verifyHomePageNavigation() throws ErrorHandler {
	try {
		GenericUtils.verifyLink("https://www.jpmorgan.com/global");
	}
		catch (Exception e) {
			throw new ErrorHandler("An error occurred during the action.");
		}

	}

	@Then("verify user verify that the J.P. Morgan logo is shown")
	public void ValidateLogo() throws ErrorHandler {
		try {
			landingPage.verifyImage();
			test.log(Status.PASS, "Step executed successfully.");
		}
		catch (Exception e) {
			throw new ErrorHandler("An error occurred during the action.");
	}
	}
	


	
}
