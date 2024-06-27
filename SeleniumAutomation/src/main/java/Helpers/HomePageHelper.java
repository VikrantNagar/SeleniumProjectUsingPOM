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

	public void testOneWayFlightBookingFlow(String departureLocation) throws InterruptedException {

		//Click on flights
		homepage.clickFlights();

		//Click on poker rules option in drop-down
		homepage.clickOneWayFlights();
		
		//Click on leaving from text field
		homepage.clickLeavingFrom();
		
		//enter departure location
		homepage.enterDepartureLocation(departureLocation);

	}

}
