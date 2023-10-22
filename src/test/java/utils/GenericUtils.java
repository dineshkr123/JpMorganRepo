package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;

public class GenericUtils {
	public static WebDriver driver;
	
	public GenericUtils(WebDriver driver)
	{
		this.driver = driver;
	}
	

	public void navigateToURL(String URL) {
		System.out.println("Navigating to: " + URL);
		System.out.println("Thread id = " + Thread.currentThread().getId());

		try {
			driver.navigate().to(URL);
		} catch (Exception e) {
			System.out.println("URL did not load: " + URL);
			throw new TestException("URL did not load");
		}
	}

	public String getPageTitle() {
		try {
			System.out.print(String.format("The title of the page is: %s\n\n", driver.getTitle()));
			return driver.getTitle();
		} catch (Exception e) {
			throw new TestException(String.format("Current page title is: %s", driver.getTitle()));
		}
	}

	public WebElement getElement(By selector) {
		try {
			return driver.findElement(selector);
		} catch (Exception e) {
			System.out.println(String.format("Element %s does not exist - proceeding", selector));
		}
		return null;
	}




	public void sendKeys(By selector, String value) {
		WebElement element = getElement(selector);
		clearField(element);
		try {
			element.sendKeys(value);
		} catch (Exception e) {
			throw new TestException(String.format("Error in sending [%s] to the following element: [%s]", value, selector.toString()));
		}
	}

	public void clearField(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
		}
	}
	public static WebElement waitForElementTobeClickable(WebElement element , int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		System.out.println("Got the element to be clickable within 10 seconds" + element);
		return element;
	}
	public void click(By selector) {
		WebElement element = getElement(selector);
		waitForElementTobeClickable(element ,10);
		try {
			element.click();
		} catch (Exception e) {
			throw new TestException(String.format("The following element is not clickable: [%s]", selector));
		}
	}
	public static boolean verifyLink(String url) {

			try {
				URL link = new URL(url);
				HttpURLConnection httpURLConnection = (HttpURLConnection) link.openConnection();
				httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
				httpURLConnection.connect();
				if (httpURLConnection.getResponseCode() == 200) {
					System.out.println(url + " - " + httpURLConnection.getResponseMessage());
					return true;
				} else {
					System.out.println(url + " - " + httpURLConnection.getResponseMessage() + " - " + "is a broken link");
					return false;
				}
			} catch (Exception e) {
				System.out.println(url + " - " + "is a broken link");
				return false;
			}

	}

	public static boolean isElementPresent(By locatorKey) {
		try {
			driver.findElement(locatorKey);
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

}
