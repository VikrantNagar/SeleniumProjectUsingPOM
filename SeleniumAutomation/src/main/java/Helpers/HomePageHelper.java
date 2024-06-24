package Helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import Pages.HomePage;
import Utility.Elements;

public class HomePageHelper {

	WebDriver driver;

	HomePage homepage;
	Elements element;

	public HomePageHelper(WebDriver driver) {
		this.driver = driver;
		homepage = new HomePage(driver);
		element = new Elements(driver);

		PageFactory.initElements(driver, HomePage.class);
	}

	public void testHomePage() throws InterruptedException {

		//Click on how to play 
		homepage.clickHowToPlay();

		//Click on poker rules option in dropdown
		homepage.clickPokerRules();

	}

}
