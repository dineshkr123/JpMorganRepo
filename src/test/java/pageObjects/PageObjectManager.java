package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public LandingPage landingPage;
	public WebDriver driver;
	public SearchPage searchPage;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}

	
	
	public LandingPage getLandingPage()
	{
	
	 landingPage= new LandingPage(driver);
	 return landingPage;
	}
	
	public SearchPage getSearchPage()
	{
		searchPage = new SearchPage(driver);
		return searchPage;
	}
}
