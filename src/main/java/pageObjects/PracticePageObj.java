package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PracticePageObj {
	
	WebDriver driver;

	public PracticePageObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	private @FindBy (id="autocomplete")
	WebElement country;
	
	public WebElement country() {
		return country;
	}

	
}
