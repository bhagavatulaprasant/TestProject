
//Test case for adding a product to cart

package com.Amazon.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Amazon.Pages.AmazonHomePage;

public class AddingToShoppingCart {

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
	}
	@Test(priority = 2)
	@Parameters({"searchText","ProductName","Value"})
	public void addingToProductCart(String searchText,String ProductName,String Value) throws InterruptedException
	{
		AmazonHomePage amazonHomePage =new AmazonHomePage(driver);
		amazonHomePage.enterTextandSearch(searchText);
		System.out.println("Searching Product to be purchased...");
		amazonHomePage.selectYourProduct(ProductName);
		amazonHomePage.addProductToCart(Value);
	}
	@AfterTest
	public void closeSession()
	{
		driver.quit();	
	}
}
