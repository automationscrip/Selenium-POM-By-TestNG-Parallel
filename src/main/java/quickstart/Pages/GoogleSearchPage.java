package quickstart.Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.model.Test;

import Constants.TimeOuts;
import functionLibrary.ReportLog;

public class GoogleSearchPage  {
	
	WebDriver driver;
	
	/**
	 * Each Page class has all the WeblElements in the form of By.
	 * These WebElements can be used in the page class across all the methods.
	 */
	
	
	By searchBox= By.xpath("//input[@name='q']");
	By firstResult= By.xpath("//div[@class='g']//h3/span");
	
	
	/**
	 * Constructor of the Page class to set the driver.
	 * @param driver
	 */
	public GoogleSearchPage(WebDriver driver) {
		this.driver=driver;
	}


	public void enterKeyWord(String keyword) {
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(keyword);
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys(Keys.ENTER);
	}
	
	public void waitForResultLink(String keyword) {
		String searchResultLink="//h3[contains(.,'"+keyword+"')]";
		WebDriverWait wait= new WebDriverWait(driver, TimeOuts.DEFAULT_TIMEOUT);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(searchResultLink)));		
	}

	public  void searchKeyword(String keyword) {
		
		this.enterKeyWord(keyword);
		this.waitForResultLink(keyword);			
	}


}
