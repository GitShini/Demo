package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObj {
	WebDriver driver;

	public LoginPageObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy (css=("[id=user_email]"))
		WebElement email;
	private @FindBy (css=("[id=user_password]"))
	WebElement password;
	private @FindBy (css=("[type=submit]"))
	WebElement submit;

	public WebElement email() {
		return email;
	}
	public WebElement password() {
		return password;
	}
	public WebElement submit() {
		return submit;
	}
}
