/**
 * 
 */
package com.Amazon.Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * @author Prasant
 *
 *Implemented framework is Page Object Model using Data Driven Testing where all the related test Data and test cases are kept separated from the Test Script.
 *So, if there is any functionality modification in the future then we just have add or modify the code in script only and no changes are required in the test
 *cases.Similarly, if there is any change in test data then we can directly go to the testng.xml file and add or modify the value parameters without affecting 
 *the test script and test cases which is most important aspect of the Data driven model and also using this we achieve modularity in our framework.
 *
 *   This class stores all the related web-element locators and corresponding methods required for Amazon Login 
 */
public class LoginAction
{
	private WebDriver driver;
	
	private By clickSignInButton =By.xpath("//*[text()='Sign in securely']");
	private By emailID =By.id("ap_email");
	private By passwordField=By.id("ap_password");
	private By clickLoginButton=By.id("signInSubmit");
	
	//All the variables are declared private in order to implement encapsulation concept so these are safe from outside access
	public LoginAction(WebDriver driver)
	{
	this.driver=driver;
	}

public void clickSignIn() throws InterruptedException
{
	WebElement ele=driver.findElement(clickSignInButton);
	boolean b=ele.isDisplayed();
	Assert.assertEquals(true, b);  //Using assertions to match that if that button is displayed or not
	driver.findElement(clickSignInButton).sendKeys(Keys.ENTER);
	Thread.sleep(7000);	
}

public void enterEmailId(String EmailID) throws InterruptedException, AWTException
{
	WebElement ele=driver.findElement(emailID);
	boolean b=ele.isEnabled();
	Assert.assertEquals(true, b); //Using assertions to match that if that web-element is enabled or not
	driver.findElement(emailID).sendKeys(EmailID);
	Thread.sleep(5000);
	Robot r =new Robot();    //Usage of Robot framework for enabling keyboard and Mouse events
	r.keyPress(KeyEvent.VK_TAB);
	r.keyRelease(KeyEvent.VK_TAB);
	Thread.sleep(3000);
	r.keyPress(KeyEvent.VK_ENTER);
	r.keyRelease(KeyEvent.VK_ENTER);
}

public void enterPassword(String Password) throws InterruptedException, AWTException
{
	WebDriverWait wait = new WebDriverWait(driver, 90);
	@SuppressWarnings("unused")
	WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ap_password")));   //Explicit wait based on some condition
	driver.findElement(passwordField).sendKeys(Password);
	Thread.sleep(5000);
}

public void clickLoginInButton() throws InterruptedException
{
	WebElement ele=driver.findElement(clickLoginButton);
	boolean b=ele.isEnabled();
	Assert.assertEquals(true, b); //Using assertions to match that if that button is enabled or not
	driver.findElement(clickLoginButton).sendKeys(Keys.ENTER);
}
}