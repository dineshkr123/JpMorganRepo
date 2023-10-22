package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

import java.io.IOException;

public class TestContextSetup extends TestBase{

	public static PageObjectManager pageObjectManager;
	public static TestBase testBase;
	public static GenericUtils genericUtils;

	
	public TestContextSetup() throws IOException
	{
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/ExtentReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		testBase = new TestBase();
		pageObjectManager = new PageObjectManager(testBase.WebDriverManager());
		genericUtils = new GenericUtils(testBase.WebDriverManager());

	}
	
}
