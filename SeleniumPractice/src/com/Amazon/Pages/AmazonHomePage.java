/**
 * 
 */
package com.Amazon.Pages;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author Prasant
 *
 *Implemented framework is Page Object Model using Data Driven Testing where all the related test Data and test cases are kept separated from the Test Script.
 *So, if there is any functionality modification in the future then we just have add or modify the code in script only and no changes are required in the test
 *cases.Similarly, if there is any change in test data then we can directly go to the testng.xml file and add or modify the value parameters without affecting 
 *the test script and test cases which is most important aspect of the Data driven model and also using this we achieve modularity in our framework.
 *
 *Usage of comments increases the readability and also helps in understanding the code properly 
 *
 *This class contains the necessary Web-element locators and corresponding methods related to the Sign-In and Login Activity Web-page
 */

public class AmazonHomePage 
{

	//All the variables are declared private in order to implement encapsulation concept so these are safe from outside access
	
	private WebDriver driver;
	
	private By textBox =By.id("twotabsearchtextbox");
	private By searchResultsButton=By.xpath("//input[@class='nav-input' ]");	
	private By iterateThruSearchResults=By.tagName("a");
	private By addToCart=By.xpath("//*[text()='Add to Cart']");
	private By quantity=By.name("quantity");
	private By scrollView=By.xpath("//*[text()='Books for JAVA - Programming, Technology & Script']");
	public AmazonHomePage(WebDriver driver)  //Constructor used to access the immediate driver instance variable of the class
	{
		this.driver=driver;
	}
	
	public void enterTextandSearch(String searchText) throws InterruptedException
	{
		driver.findElement(textBox).sendKeys(searchText);
		WebElement ele=driver.findElement(searchResultsButton);
		JavascriptExecutor js=(JavascriptExecutor)driver;   //DownCasting the driver object of web-driver Interface to JavaScriptExecutor Interface 
		js.executeScript("arguments[0].click();", ele);     //Using JavaScriptExecutor Interface for clicking in the text Box
		Thread.sleep(7000);
	}
	public void selectYourProduct(String ProductName) throws InterruptedException
	{
		List<WebElement> links=driver.findElements(iterateThruSearchResults);
		Thread.sleep(7000);
		for(WebElement ele:links)  //Enhanced For loop for iterating thru all the links present on a web page
		{
			try {
				
				if(ele.getText().equals(ProductName)) 
				{
						links=driver.findElements(iterateThruSearchResults);
						System.out.println("True "+ele.getText());
						String st=ele.getAttribute("href");
						System.out.println(st);
						driver.findElement(By.cssSelector("body")).sendKeys(Keys.chord(Keys.CONTROL,"t"));
						driver.get(st);
						Thread.sleep(6000);
						System.out.println("Link opened for the product to be added to cart");
				}
				else
				{
					;
				}
			} catch (InterruptedException|StaleElementReferenceException|NoSuchElementException e) {  //Usage of multi-catch block for catching multiple exceptions
				WebElement ele1=driver.findElement(addToCart);
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("arguments[0].click();", ele1);
				Thread.sleep(10000);
			}
		}
	}
	public void addProductToCart(String Value) throws InterruptedException
	{
		{
			WebElement ele=driver.findElement(quantity);
			Select s=new Select(ele);   //Usage of select class for selecting a value from a dropdown
			s.selectByVisibleText(Value);
			WebElement ele1=driver.findElement(addToCart);
			JavascriptExecutor js=(JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", ele1);
		}
	}
	
	public void scrollIntoViewProduct(String ProductName) throws InterruptedException
	{
		String st="";
		List<WebElement> links=driver.findElements(iterateThruSearchResults);  //Storing all the links in List Interface which is child interface of Collection
		Thread.sleep(7000);
		for(WebElement ele:links)
		{
			st+=ele.getText();
			if(st.equals(ProductName)) 
			{
					System.out.println("True "+st);
					st=ele.getAttribute("href");
					System.out.println(st);
					WebDriverWait wait = new WebDriverWait(driver, 90);
					@SuppressWarnings("unused")
					WebElement ele1 = wait.until(ExpectedConditions.visibilityOfElementLocated(scrollView));
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0, 500)", "");  //Using JavaScriptExecutor Interface for scrolling in to view the required product locator    
			}
			else
			{
				st="";
			}
		}
	}
}