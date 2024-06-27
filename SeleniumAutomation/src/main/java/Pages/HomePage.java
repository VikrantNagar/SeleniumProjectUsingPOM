package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Elements;

public class HomePage {

	WebDriver driver;
	Elements elements;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elements = new Elements(driver);
	}

	@FindBy(xpath = "//span[contains(text(),'Flights')]")
	private WebElement flights;

	@FindBy(xpath = "//span[contains(text(),'One-way')]")
	private WebElement oneWayFlights;
	
	@FindBy(xpath = "//button[@aria-label='Leaving from']")
	private WebElement leavingFrom;
	
	@FindBy(xpath = "//input[@placeholder = 'Leaving from']")
	private WebElement departureFrom;
	

	public void clickFlights(){
		Elements.clickElement(driver, flights);
	}

	public void clickOneWayFlights() {
		Elements.clickElement(driver, oneWayFlights);
	}
	
	public void clickLeavingFrom() {
		Elements.clickElement(driver, leavingFrom);
	}
	
	public void enterDepartureLocation(String departureLocation) {
		Elements.sendText(driver, departureLocation, departureFrom);
	}

}
