package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import functionLibrary.ReportLog;
import functionLibrary.Utilities;

public class Listeners implements ITestListener {
ExtentReports extent= ReportLog.extentReportGenerator();
ExtentTest test;
private static ThreadLocal<ExtentTest> extentTest= new ThreadLocal<ExtentTest>();

	public void onTestStart(ITestResult result) {
		
		 test= extent.createTest(result.getMethod().getMethodName());
		 extentTest.set(test);
		 extentTest.get().log(Status.INFO, "Test Started");
	}

	public void onTestSuccess(ITestResult result) {
	
		 extentTest.get().log(Status.PASS, result.getName()+" is Passed");

		
	}

	public void onTestFailure(ITestResult result) {
		 extentTest.get().log(Status.INFO, result.getName()+" is Failed");
		 extentTest.get().fail(result.getThrowable());
	
	}

	public void onTestSkipped(ITestResult result) {
		
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

		
	}

	public void onStart(ITestContext context) {
	
		
	}

	public void onFinish(ITestContext context) {

		extent.flush();
	}

}
