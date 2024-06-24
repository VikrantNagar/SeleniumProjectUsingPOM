package Utility;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Elements {

	WebDriver driver;

	public Elements(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver waitForClickableElement(WebElement element) throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
		wait.until(ExpectedConditions.visibilityOf(element));

		return (driver);

	}

	public void clickElement(WebDriver driver, WebElement elements) throws InterruptedException {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//			wait.until(ExpectedConditions.visibilityOf(element));
		waitForClickableElement(elements);
		elements.click();
	}

}
