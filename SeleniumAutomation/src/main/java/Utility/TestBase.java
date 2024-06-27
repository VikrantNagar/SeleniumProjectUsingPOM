package Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class TestBase {

	public static WebDriver driver;

	public static Properties properties;
	
	public static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();
	
	public TestBase(){
			try {
				properties = new Properties();
				FileInputStream fis = new FileInputStream("config.properties");
				properties.load(fis);
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
	}

	public WebDriver setup() throws IOException, InterruptedException {
		
		String url = properties.getProperty("url");
		System.out.println(url);
		
		System.setProperty(properties.getProperty("system_Key"), properties.getProperty("system_Value"));
		
		driver = new FirefoxDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		Thread.sleep(5000);

		// set driver to threadDriver so that we can reference the instance of same
		// driver where ever required via getDriver method
		threadDriver.set(driver);
		return threadDriver.get();
	}

	public synchronized WebDriver getDriver() throws IOException, InterruptedException {
		return setup();
	}
	
//	@AfterMethod
//	public void tearDown() {
//		driver.quit();
//	}

}
