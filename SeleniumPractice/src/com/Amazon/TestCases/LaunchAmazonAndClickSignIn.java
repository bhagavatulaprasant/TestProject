
//Test case for Launching amazon and clicking on SignIn button to check its functionality

package com.Amazon.TestCases;

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
public class LaunchAmazonAndClickSignIn
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
	@Parameters({"AmazonURL"})
	public void launchAmazonAndClickSignIn(String AmazonURL) throws InterruptedException 
	{
		driver.get(AmazonURL);
		LoginAction loginPage=new LoginAction(driver);
		loginPage.clickSignIn();
		
	}
	@AfterTest
	public void closeSession()
	{
		driver.quit();	
	}
}