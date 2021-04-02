package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObj {
	WebDriver driver;

	public RegisterPageObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	 private @FindBy (id="user_name")
	WebElement fullname;
	
	public WebElement fullName() {
		return fullname;
	}
}
