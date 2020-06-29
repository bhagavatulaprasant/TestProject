/**
 * 
 */
package com.Amazon.ScreenshotCode;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

/**
 * @author Prasant
 *
 *
 */
public class Screenshot 
{
	@Test
	public static void takeScreenshots()
	{
		System.setProperty("webdriver.gecko.driver", "E:\\geckodriver-v0.26.0-win64\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		driver.manage().window().maximize();
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		 
	    try {
	        FileHandler.copy(ts.getScreenshotAs(OutputType.FILE), new File("./Screenshots/Amazon.png"));  //The screenshots will be stored in the current working directory path
	        System.out.println("Screenshot Taken");
	    } catch (WebDriverException e) {
	 
	    } catch (IOException e) {
	 
	    }
	}
}