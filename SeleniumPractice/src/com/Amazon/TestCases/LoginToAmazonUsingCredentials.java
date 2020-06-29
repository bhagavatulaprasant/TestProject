/**
 *   Test case for Logging to amazon using credentials
 */



package com.Amazon.TestCases;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.Amazon.Pages.LoginAction;

/**
 * @author Prasant
 *
 */
public class LoginToAmazonUsingCredentials 
{
	WebDriver driver;
	@BeforeTest()
	@Parameters({"BrowserDetails","ExecFilePath"})
	public void launchSession(String BrowserDetails,String ExecFilePath)
	{
		System.setProperty(BrowserDetails, ExecFilePath);
		driver = new FirefoxDriver();
	}
	@Test
	@Parameters({"AmazonURL","EmailID","Password"})
	public void launchAmazonUsingCredentials(String AmazonURL,String EmailID,String Password) throws InterruptedException, AWTException 
	{
		driver.get(AmazonURL);
		LoginAction loginPage=new LoginAction(driver);
		loginPage.clickSignIn();
		loginPage.enterEmailId(EmailID);
		System.out.println("EmailID entered...");
		//loginPage.clickContinueButton();
		loginPage.enterPassword(Password);
		System.out.println("Password entered...");
		loginPage.clickLoginInButton();
		System.out.println("Successfully logged in...");
	}
	@AfterTest
	public void closeSession()
	{
		driver.quit();	
	}
}