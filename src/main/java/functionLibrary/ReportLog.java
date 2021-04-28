package functionLibrary;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ReportLog {

	   static ExtentReports extent;
	   ExtentSparkReporter spark;
	   ExtentTest test;
	   String ScreenshotPath; 
	
	


	public static  ExtentReports extentReportGenerator() {
	
		
		 ExtentSparkReporter spark= new ExtentSparkReporter("target/Spark.html");
		 spark.config().setReportName("Page object model with parallel execution using TestNG");
		 spark.config().setDocumentTitle("ExtentReports in parallel test execution");
		 
		 extent= new ExtentReports();
		 extent.attachReporter(spark);	
		 return extent;
	}

   
}