package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	public WebDriver driver;

	public LandingPage(WebDriver driver)
	{
		this.driver = driver;
		
	}
	By image = By.xpath("//div[@class='primary-navigation-logo-link']/img[contains(@alt,'J.P.')]");
	
	public void verifyImage()
	{
		driver.findElement(image).isDisplayed();
	}
}
