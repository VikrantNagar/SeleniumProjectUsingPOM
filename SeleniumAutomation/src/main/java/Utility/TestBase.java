package Utility;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class TestBase {

	public static WebDriver driver;

	public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();

	public WebDriver setup() throws IOException {

		System.setProperty("webdriver.gecko.driver", "/Users/vikrant.nagar/Drivers/geckodriver");
		driver = new FirefoxDriver();
		driver.get("https://www.jungleepoker.com/");
		driver.manage().window().maximize();

		// set driver to threadDriver so that we can reference the instance of same
		// driver where ever required via getDriver method

		threadDriver.set(driver);
		return threadDriver.get();
	}

	public synchronized WebDriver getDriver() throws IOException {
		return setup();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
