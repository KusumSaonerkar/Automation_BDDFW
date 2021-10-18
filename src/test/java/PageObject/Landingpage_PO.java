package PageObject;

import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestContext;
import Utilities.actions;
import io.cucumber.java.Scenario;

public class Landingpage_PO extends TestContext
{
	
	
	WebDriver driver;
	WebDriverWait wait;
	Scenario Scn;
//	actions action;
	
	public static By youtube_icon = By.xpath("//ul//li[@class = 'youtube']/a");
	public static By facebook_icon = By.xpath("//ul//li[@class = 'facebook']/a");
	public static By twitter_icon = By.xpath("//ul//li[@class = 'twitter']/a");
	
	public Landingpage_PO(WebDriver driver, WebDriverWait wait, Scenario Scn)
	{
		this.driver = driver;
		this.wait = wait;
		this.Scn = Scn;
		//action = new actions(driver, wait, Scn);
	}
	
	public void allCategoryDisplayed() 
	{
		ArrayList<String> DisplayCategory = new ArrayList<>();
		DisplayCategory.add("WOMEN");
		DisplayCategory.add("DRESSES");
		DisplayCategory.add("T-SHIRTS");
		System.out.println(DisplayCategory);
		List<WebElement> Actual_Product = driver.findElements(By.xpath("//div[@id='block_top_menu']/ul/li/a"));
		for(int i=0;i<DisplayCategory.size();i++)
		{
			Assert.assertEquals("Product number " + (i+1) + " is not matched with expected",DisplayCategory.get(i), Actual_Product.get(i).getText());
		}
	}
	
	public void youtube()
	{
		action.click(youtube_icon);
		action.windowHandlle();
		
	}
	
	public void facebook()
	{
		action.click(facebook_icon);
		action.windowHandlle();
		

	}
	
	public void twitter()
	{
		action.click(twitter_icon);
		action.windowHandlle();
	}
	
	
}
