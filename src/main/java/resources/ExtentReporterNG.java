package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	static ExtentReports extent;
	public static ExtentReports extentRepo() {
		String path = System.getProperty("user.dir")+"\\Extentreports\\index.html";
		ExtentSparkReporter spark = new ExtentSparkReporter(path);
		spark.config().setDocumentTitle("Automation Report");
		spark.config().setReportName("Web Automation Results");
		
		extent = new ExtentReports();
		extent.attachReporter(spark);
		extent.setSystemInfo("Tester", "Shalini");
		return extent;
	}
}
