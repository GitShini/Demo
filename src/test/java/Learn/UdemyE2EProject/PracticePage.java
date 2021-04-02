package Learn.UdemyE2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import pageObjects.HomePageObj;
import pageObjects.PracticePageObj;

public class PracticePage {
	
	WebDriver driver;

	public void navigateToPractice() {
		HomePageObj hpo = new HomePageObj(driver);
		hpo.practice().click();
	}
	
	@Test
	public void goingToPractice() throws IOException {
		HomePage hp = new HomePage();
		driver =hp.initializeDriver();
		navigateToPractice();
		PracticePageObj ppo = new PracticePageObj(driver);
		ppo.country().sendKeys("India");
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
}
