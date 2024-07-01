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

	public void testOneWayFlightBookingFlow(String departureLocation, String arrivalLocation, String date, String fromDay, String toDay) throws InterruptedException {

		//Click on flights
		homepage.clickFlights();

		//Click on poker rules option in drop-down
		homepage.clickOneWayFlights();
		
		//Click on leaving from text field
		homepage.clickLeavingFrom();
		
		//enter departure location
		homepage.enterDepartureLocation(departureLocation);
		
		Thread.sleep(2000);
		
		//click on going to field
		homepage.clickGoingTo();
		
		//enter arrival location
		homepage.enterArrivalTo(arrivalLocation);
		
		homepage.clickDate();

//		String currMonth = homepage.getCurrentMonth();
		
		
		while(true) {
			
			String currMonth = homepage.getCurrentMonth();
			System.out.print(currMonth);
			System.out.print(date);
			
			if(currMonth.equals(date)) {
				break;
			}
			else {
				homepage.clickNextMonth();
			}
		}
		
		//Select from date
		homepage.clickDayElement(fromDay);
				
		//click Done
		homepage.clickDone();
		
		//Click Search
		homepage.clickSearch();
		
	}

}
