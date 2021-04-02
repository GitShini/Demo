package Learn.UdemyE2EProject;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.HomePageObj;
import pageObjects.LoginPageObj;
import resources.Base;

public class HomePage extends Base{
	WebDriver driver;

	@Test
		public WebDriver launchApp() throws IOException {
		driver=initializeDriver();
	    return driver;
	}
	
	@Test
	public void checkAvailabiltyOfFeatured() throws IOException {
		launchApp();
		HomePageObj hpo = new HomePageObj(driver);
		String actual = hpo.courses().getText();
		Assert.assertEquals("FEATURED COURSES", actual);
		Assert.assertFalse(hpo.navigationBar().isDisplayed());
		
		hpo.register().click();
	}
	
	@AfterTest
	public void close() {
		driver.close();
	}
	
}
