package Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitForElement
{
	WebDriver driver;
	WebDriverWait wait;
	
	
	public WaitForElement(WebDriver driver, WebDriverWait wait)
	{
		this.driver= driver;
		this.wait= wait;
	}
	
	
	public void waitForElementClickable(By locator)
	{
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	
	public void waitForElementVisibilityOfElementLocated(By locator)
	{
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void waitForElementPresent(By locator) 
	{
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	
	public  void Wait_KiloBytes() 
	{
		try 
		{
			Thread.sleep(3000);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
