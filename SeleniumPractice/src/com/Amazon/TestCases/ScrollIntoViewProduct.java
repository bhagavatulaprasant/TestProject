

//Test Case for Scrolling Into view a particular product

package com.Amazon.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Amazon.Pages.AmazonHomePage;

public class ScrollIntoViewProduct {

	WebDriver driver;
	@BeforeTest()
	@Parameters({"BrowserDetails","ExecFilePath"})
	public void launchSession(String BrowserDetails,String ExecFilePath)
	{
		System.setProperty(BrowserDetails, ExecFilePath);
		driver = new FirefoxDriver();
	}
	@Test(priority = 1)
	@Parameters({"AmazonURL"})
	public void launchAmazon(String AmazonURL) throws InterruptedException 
	{
		driver.get(AmazonURL);
		driver.manage().window().maximize();
	}
	@Test(priority = 2)
	@Parameters({"searchText","ProductName"})
	public void addingToProductCart(String searchText,String ProductName) throws InterruptedException
	{
		AmazonHomePage amazonHomePage =new AmazonHomePage(driver);
		amazonHomePage.enterTextandSearch(searchText);
		System.out.println("Searching Product to be purchased...");
		amazonHomePage.scrollIntoViewProduct(ProductName);
	}
	@AfterTest
	public void closeSession()
	{
		driver.quit();	
	}
	
}