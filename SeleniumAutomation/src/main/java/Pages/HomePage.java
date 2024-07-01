package Pages;

import org.openqa.selenium.By;
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
	
	@FindBy(xpath = "//button[@aria-label='Going to']")
	private WebElement goingTo;
	
	@FindBy(xpath = "//input[@placeholder='Going to']")
	private WebElement arrivalTo;
	
	@FindBy(xpath = "//button[contains(@aria-label, 'Date')]")
	private WebElement date;
	
	@FindBy(xpath = "//span[@class = 'uitk-align-center uitk-month-label']")
	private WebElement currMonth;
	
	@FindBy(xpath = "//div[@class='uitk-cal-controls-button uitk-cal-controls-button-inset-multi uitk-cal-controls-button-next']")
	private WebElement nextMonth;
	
	@FindBy(xpath = "//button[@data-stid='apply-date-selector']")
	private WebElement done;
	
	@FindBy(xpath = "//button[contains(@aria-label,'Travelers')]")
	private WebElement travelers;
	
	@FindBy(id="search_button")
	private WebElement search;
	
	

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
	
	public void clickGoingTo(){
		Elements.clickElement(driver, goingTo);
	}
	
	public void enterArrivalTo(String arrivalLocation){
		Elements.sendText(driver, arrivalLocation ,arrivalTo);
	}
	
	public void clickDate() {
		Elements.clickElement(driver, date);
	}
	
	public String getCurrentMonth() {
		return Elements.getText(driver, currMonth);
	}

	public void clickNextMonth(){
		Elements.clickElement(driver, nextMonth);
	}
	
	public void clickDone() {
		Elements.clickElement(driver, done);
	}
	
	private By dayLocator(String dayText) {
        return By.xpath("//div[contains(text(), '" + dayText + "')]"); 
    }
	
	// Method to interact with the element
    public void clickDayElement(String fromDay) {
        driver.findElement(dayLocator(fromDay)).click();
    }	
    
    public void clickTravelers() {
    	Elements.clickElement(driver, travelers);
    }
    
    public void clickSearch() {
    	Elements.clickElement(driver, search);
    }
    
    
}
