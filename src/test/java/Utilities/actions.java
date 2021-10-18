package Utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestContext;
import io.cucumber.java.Scenario;

public class actions extends TestContext
{

		WebDriver driver;
		WebDriverWait wait;
		Scenario scn;
		Actions Element;
	//	Wait wait1;
	//	WaitForElement waitForElement ;
		
		public actions(WebDriver driver, WebDriverWait wait, Scenario scn)
		{
			this.driver = driver;
			this.wait = wait;
			this.scn = scn;
			Element = new Actions(this.driver);
			//waitForElement = new WaitForElement(this.driver, this.wait);
			
		}
		
		public void click(By locator)
		{
			WebElement element= driver.findElement(locator);
			element.click();
			//waitForElement.waitForElementVisibilityOfElementLocated(locator);
		}
		
		public void windowHandlle() 
		{
			Set<String> handle=driver.getWindowHandles();
			Iterator<String> it=handle.iterator();
			String win1=it.next();
			String win2=it.next();
			driver.switchTo().window(win2);
		}
		
		public void SendText(By locator, String text)
		{
			WebElement element = driver.findElement(locator);
			element.sendKeys(text);
		}
		
		public void moveToElement(By locator)
		{
			Element.moveToElement(driver.findElement(locator)).build().perform();
			waitForElement.waitForElementPresent(locator);
		}
		
		public String GetText(By locator)
		{
			String text=driver.findElement(locator).getText();
			return text;
		}
		
}
