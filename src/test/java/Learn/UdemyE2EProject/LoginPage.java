package Learn.UdemyE2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObj;
import pageObjects.LoginPageObj;

public class LoginPage {

	WebDriver driver;


	public void navigateToLogin() {
		HomePageObj hpo = new HomePageObj(driver);
		hpo.login().click();
	}
	
	@Test(dataProvider ="getData")
	public void login(String username, String password) throws IOException {
		HomePage hp = new HomePage();
		driver =hp.initializeDriver();
		 navigateToLogin();
		LoginPageObj lpo = new LoginPageObj(driver);
		lpo.email().sendKeys(username);
		lpo.password().sendKeys(password);
		lpo.submit();
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0]="restriceduser@abc.com";
		data[0][1]="123";
		
		data[1][0]="nonrestriceduser@abc.com";
		data[1][1]="456";		
		return data;
	}

}
