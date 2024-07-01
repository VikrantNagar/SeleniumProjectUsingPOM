package Utility;

import java.awt.RenderingHints.Key;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {

	WebDriver driver;

	public Elements(WebDriver driver) {
		this.driver = driver;
	}
	
	//Method to wait for element to visible on a page
	public static void waitForElementToVisibleOnPage(WebDriver driver, WebElement element, Duration totalTimeToWaitInSeconds) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, totalTimeToWaitInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));		
		}
		catch(org.openqa.selenium.TimeoutException e){
			System.out.println(element +" is not visible on page");
			System.out.println(e.getMessage());
		}
	}
	
	//Method to click an element
	public static void clickElement(WebDriver driver, WebElement element) {
		waitForElementToVisibleOnPage(driver, element, Duration.ofSeconds(3));
		element.click();
	}
	
	//Method to check that an element is present or not
	public static boolean isElementPresent(WebDriver driver, WebElement element) throws InterruptedException {
		Thread.sleep(1000);
		try {
			element.isDisplayed();
			System.out.println(element + "- is displayed");
			return true;
		}catch(NoSuchElementException e){
			System.out.println(element + "- is not displayed");
			return false;
		}
	}

	//Method to send Text in a field
	public static void sendText(WebDriver driver, String text, WebElement element) {
		waitForElementToVisibleOnPage(driver, element, Duration.ofSeconds(3));
			element.sendKeys(text);
			element.sendKeys(Keys.ENTER);
			System.out.println(text + "- is entered");		
	}
	
	public static String getText(WebDriver driver, WebElement element) {
		waitForElementToVisibleOnPage(driver, element, Duration.ofSeconds(3));
		return element.getText();
		
	}
	

}
