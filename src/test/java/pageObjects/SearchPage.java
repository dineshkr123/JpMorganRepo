package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.GenericUtils;

public class SearchPage {
	public WebDriver driver;

	public SearchPage(WebDriver driver)
	{
		this.driver = driver;
	}
	By search = By.id("APjFqb");
	By firstSearchResult=By.xpath("//*[@id=\"rso\"]//span/a/h3[text()='J.P. Morgan | Official Website']");

	public void searchItem(String textTobeSearched) {
		driver.findElement(search).sendKeys(textTobeSearched);
		driver.findElement(search).sendKeys(Keys.ENTER);
	}
	public boolean verifyFirstResultAfterSearch(String textTobeSearched)
	{
		return driver.findElement(firstSearchResult).isDisplayed();
	}
	public Boolean verifyFirstResultAfterSearchNegative()
	{
		Boolean flag=GenericUtils.isElementPresent(firstSearchResult);
		return flag;
	}
	public void clickFirstResultAfterSearch(String textTobeSearched)
	{
		 driver.findElement(firstSearchResult).click();
	}
}
