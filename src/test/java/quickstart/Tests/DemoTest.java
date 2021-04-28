package quickstart.Tests;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



import functionLibrary.ReportLog;
import functionLibrary.TestData;
import io.github.bonigarcia.wdm.WebDriverManager;
import quickstart.Pages.GoogleSearchPage;
import quickstart.Pages.GoogleSearchResultPage;


public class DemoTest {


	String currDir;
	String chrmdriverPath;


	@BeforeSuite
	public void startTestSuite() {

		currDir= System.getProperty("user.dir");
		//chrmdriverPath=currDir+"\\..\\..\\jars\\chromedriver.exe";

	}



	@Test
	public  void GoogleSearch_automationScript(ITestContext testDetails) throws IOException {
		testDetails.setAttribute("GoogleSearch_automationScript Fail Detail", "");
		GoogleSearchPage googleSearch ;
		GoogleSearchResultPage googlesearchresults;
		TestData testdata= new TestData(currDir+"\\TestData\\searchData.xlsx");

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();

		driver.get("https://google.com");
		driver.manage().window().maximize();

		googleSearch= new GoogleSearchPage(driver);
		googlesearchresults= new GoogleSearchResultPage(driver);		
		googleSearch.searchKeyword("automationScript");		


		boolean isDisplayed= googlesearchresults.isLinkDisplayed("automationScript");		
		Assert.assertEquals(isDisplayed, true, "automationScript Link is not displayed on Google Search results page 1");

		String firstLinkText= googlesearchresults.getFirstResult().getAttribute("innerText");	
		boolean isFirstLink=firstLinkText.contains("automationScript");

		Assert.assertEquals(isFirstLink, true, "automationScript Link is not displayed as 1st link on Google Search results page 1");
		Assert.assertEquals(true, true, "Sample Test data fetched from test data file for test case 1= "+testdata.getTestData("1", "Keyword"));
		driver.quit();
	}


	@Test
	public  void GoogleSearch_Facebook(ITestContext testDetails) throws IOException {
		testDetails.setAttribute("details", "text to check2");
		GoogleSearchPage googleSearch ;
		GoogleSearchResultPage googlesearchresults;
		TestData testdata= new TestData(currDir+"\\TestData\\searchData.xlsx");

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();

		driver.get("https://google.com");
		driver.manage().window().maximize();

		googleSearch= new GoogleSearchPage(driver);
		googlesearchresults= new GoogleSearchResultPage(driver);		
		googleSearch.searchKeyword("Facebook");			
		boolean isDisplayed= googlesearchresults.isLinkDisplayed("Facebook");	
		Assert.assertEquals(isDisplayed, true,"Facebook Link is not displayed on Google Search results page 1");

		String firstLinkText= googlesearchresults.getFirstResult().getAttribute("innerText");	
		Assert.assertTrue(firstLinkText.contains("Facebook"), "Facebook Link is not displayed as 1st link on Google Search results page 1");

		// Sample code to get test data from test data file.
		System.out.println("Sample Test data fetched from test data file for test case 2= "+testdata.getTestData("2", "Keyword"));

		driver.quit();


	}



	@Test
	public  void GoogleSearch_Twitter(ITestContext testDetails) throws IOException {
		testDetails.setAttribute("details", "text to check3");
		GoogleSearchPage googleSearch ;
		GoogleSearchResultPage googlesearchresults;
		TestData testdata= new TestData(currDir+"\\TestData\\searchData.xlsx");

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();


		driver.get("https://google.com");
		driver.manage().window().maximize();

		googleSearch= new GoogleSearchPage(driver);
		googlesearchresults= new GoogleSearchResultPage(driver);		
		googleSearch.searchKeyword("Twitter");			
		boolean isDisplayed= googlesearchresults.isLinkDisplayed("Twitter");	

		Assert.assertEquals(isDisplayed, true,"Twitter Link is not displayed on Google Search results page 1");
		String firstLinkText= googlesearchresults.getFirstResult().getAttribute("innerText");	
		Assert.assertTrue(firstLinkText.contains("Twitter"), "Twitter Link is not displayed as 1st link on Google Search results page 1");
		
		// Sample code to get test data from test data file.
		System.out.println("Sample Test data fetched from test data file for test case 3= "+testdata.getTestData("3", "Keyword"));

		driver.quit();
	}


	@Test
	public  void GoogleSearch_LinkedIn(ITestContext testDetails) throws IOException {
		testDetails.setAttribute("details", "text to check4");

		GoogleSearchPage googleSearch ;
		GoogleSearchResultPage googlesearchresults;
		TestData testdata= new TestData(currDir+"\\TestData\\searchData.xlsx");

		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();

		driver.get("https://google.com");
		driver.manage().window().maximize();

		googleSearch= new GoogleSearchPage(driver);
		googlesearchresults= new GoogleSearchResultPage(driver);		
		googleSearch.searchKeyword("LinkedIn");			
		boolean isDisplayed= googlesearchresults.isLinkDisplayed("LinkedIn");		

		Assert.assertEquals(isDisplayed, true,"LinkedIn Link is not displayed as 1st link on Google Search results page 1");
		String firstLinkText= googlesearchresults.getFirstResult().getAttribute("innerText");
		Assert.assertTrue(firstLinkText.contains("LinkedIn"), "LinkedIn Link is not displayed as 1st link on Google Search results page 1");

		// Sample code to get test data from test data file.
		System.out.println("Sample Test data fetched from test data file for test case 4= "+testdata.getTestData("4", "Keyword"));

		driver.quit();

	}



}
