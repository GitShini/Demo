package Learn.UdemyE2EProject;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import resources.ExtentReporterNG;

public class Listeners extends Base implements ITestListener {

	 ExtentTest test;
	 ExtentReports extent = ExtentReporterNG.extentRepo();
	 ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	public void onFinish(ITestContext arg0) {
		extent.flush();	
	}

	public void onStart(ITestContext arg0) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult arg0) {
		extentTest.get().fail(arg0.getThrowable());
		WebDriver driver;
		String testCaseName=arg0.getMethod().getMethodName();
		System.out.println("From listener: "+testCaseName);
		try {
			driver=(WebDriver)arg0.getTestClass().getRealClass().getDeclaredField("driver").get(arg0.getInstance());			
			//getScreenShot(testCaseName,driver);
			extentTest.get().addScreenCaptureFromPath(getScreenShot(testCaseName,driver), testCaseName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		test = extent.createTest(arg0.getMethod().getMethodName());
		extentTest.set(test);
	}

	public void onTestSuccess(ITestResult arg0) {
		extentTest.get().log(Status.PASS, "TestPassed");
		
	}

}
