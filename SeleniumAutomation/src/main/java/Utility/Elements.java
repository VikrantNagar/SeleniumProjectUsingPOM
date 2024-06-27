package Utility;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {

	WebDriver driver;

	public Elements(WebDriver driver) {
		this.driver = driver;
	}

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
	

	public static void clickElement(WebDriver driver, WebElement element) throws InterruptedException {
		waitForElementToVisibleOnPage(driver, element, Duration.ofSeconds(3));
		element.click();
	}
	
	
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

}
