package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class TestBase {
	protected ExtentTest test;
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
	public WebDriver WebDriverManager() throws IOException
	{
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("url");
		String browser_properties = prop.getProperty("browser");
		String browser_maven=System.getProperty("browser");
		
		String browser = browser_maven!=null ? browser_maven : browser_properties;
		if(driver == null)
		{
			if(browser.equalsIgnoreCase("chrome"))
			{
		       System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//src//main//resources//chromedriver");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				 driver = new ChromeDriver(options);
			}
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver","//Users//dineshkr//Downloads//geckodriver 5");
				driver = new FirefoxDriver();
			}

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		    driver.get(url);
		}
		
		return driver;
		
	}
	
	
	
}

