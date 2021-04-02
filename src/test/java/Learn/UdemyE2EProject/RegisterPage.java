package Learn.UdemyE2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObj;
import pageObjects.RegisterPageObj;

public class RegisterPage {
	WebDriver driver;

	
		public void navigateToRegister() {
		HomePageObj hpo = new HomePageObj(driver);
		hpo.register().click();
		}
		
	@Test
		public void signingIn() throws IOException {
		HomePage hp = new HomePage();
		driver =hp.initializeDriver();
		navigateToRegister();
		RegisterPageObj rpo = new RegisterPageObj(driver);
		rpo.fullName().sendKeys("shalini");
		}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	
	}

