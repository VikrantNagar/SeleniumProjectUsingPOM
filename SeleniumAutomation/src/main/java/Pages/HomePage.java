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

	@FindBy(xpath = "//li[@class = 'header_active_li'][1]")
	private WebElement howToPlay;

	@FindBy(xpath = "//ul[@class = 'web-dropdown-1']/li[2]")
	private WebElement pokerRules;

	public void clickHowToPlay() throws InterruptedException {
		Elements.clickElement(driver, howToPlay);
	}

	public void clickPokerRules() throws InterruptedException {
		Elements.clickElement(driver, pokerRules);
	}

}
