package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	WebDriver driver;

	public WebDriver initializeDriver() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		//String browserName = System.getProperty("browser");
		String browserName = prop.getProperty("browser");
		String urlName = prop.getProperty("url");
		System.out.println(browserName);
		System.out.println(urlName);

		if (browserName.contains("chrome")) {
			System.setProperty("WebDriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions option = new ChromeOptions();
			if(browserName.contains("headless")){
				option.addArguments("headless");
			}
			driver = new ChromeDriver(option);

			driver.get(urlName);
		} else if (browserName.equalsIgnoreCase("IE")) {
			driver = new InternetExplorerDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.get(urlName);
		} else {
			System.out.println("No configuration found");
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\Screenshots\\"+testCaseName+".png";
		org.apache.commons.io.FileUtils.copyFile(source, new File(destinationFile));	
		return destinationFile;
	}
}
