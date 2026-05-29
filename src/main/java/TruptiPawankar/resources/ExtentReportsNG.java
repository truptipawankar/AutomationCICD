package TruptiPawankar.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {

	public  static ExtentReports getReportObject()
	{

String path= System.getProperty("usr.dir")+"//reports//index.html";
ExtentSparkReporter report = new ExtentSparkReporter(path);
report.config().setReportName("Autoamtion Suit Report");
report.config().setDocumentTitle("Test Report");

ExtentReports extent = new ExtentReports();
extent.attachReporter(report);
extent.setSystemInfo("Tester", "Trupti");

return extent;

	}
}
