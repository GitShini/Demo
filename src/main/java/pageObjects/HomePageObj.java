package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageObj {
	
	WebDriver driver;

	public HomePageObj(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	private @FindBy (css=("a[href*=sign_in]"))
		WebElement signin;

	private @FindBy (xpath="//section[@id='content']/div/div/h2")
		WebElement courses;
	
	private @FindBy(css=("[class='navbar-collapse collapse']"))
		WebElement navigationbar;
	
	private @FindBy(css=("[href*=sign_up]"))
	WebElement register;
	
	private @FindBy(css=("[href*=Practice]"))
	WebElement practice;
	
	public WebElement login() {
		return signin;		
	}
	
	public WebElement courses() {
		return courses;		
	}
	
	public WebElement navigationBar() {
		return navigationbar;		
	}
	
	public WebElement register() {
		return register;		
	}
	
	public WebElement practice() {
		return practice;		
	}
	
	
}
