package PageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestContext;
import Utilities.WaitForElement;
import Utilities.actions;
import io.cucumber.java.Scenario;

public class Products_PO extends TestContext

{
	private static final Logger logger = LogManager.getLogger(Products_PO.class);
	WebDriver driver;
	WebDriverWait wait;
	Scenario Scn;
//	actions action;
//	WaitForElement waitForElement;
//_____________________________T-Shirt_______________________	
	public static By login = By.xpath("//a[@class = 'login']");
	public static By mailId_Box = By.xpath("//input[@id = 'email']");
	public static By Password_Box = By.xpath("//input[@id = 'passwd']");
	public static By Signin = By.xpath("//span/i[@class = 'icon-lock left']");
	public static By T_Shirt = By.xpath("//ul[@class = 'sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[3]/a[@title = 'T-shirts']");
	public static By Move = By.xpath("//div[@class = 'right-block']");
	public static By More = By.xpath("//a[@title= 'View']/span");
	public static By send_a_friend  = By.xpath("//a[@id ='send_friend_button']");
	public static By friend_name = By.xpath("//input[@id ='friend_name']");
	public static By friend_email = By.xpath("//input[@id ='friend_email']");
	public static By Send = By.xpath("//button[@id ='sendEmail']/span");

//----------------------------------Cart page-----------------------//
	
	public static By product_1 = By.xpath("//ul[@id='homefeatured']/li/div/div/div/a[@data-id-product = '1']/span");
	public static By product_2 = By.xpath("//ul[@id='homefeatured']/li/div/div/div/a[@data-id-product = '2']/span");
	public static By product_3 = By.xpath("//ul[@id='homefeatured']/li/div/div/div/a[@data-id-product = '7']/span");
	public static By Continue_shopping = By.xpath("//span[@title='Continue shopping']//span[1]");
	public static By Cart_qnty = By.xpath("//span[@class = 'ajax_cart_quantity unvisible']");
	public static By P_1 = By.xpath("//ul[@id='homefeatured']//li//div//div//h5//a[@title = 'Faded Short Sleeve T-shirts']");
	public static By P_2 = By.xpath("//ul[@id='homefeatured']//li//div//div//h5//a[@title = 'Blouse']");
	public static By P_3 = By.xpath("//ul[@id='homefeatured']//li//div//div//h5//a[@title = 'Printed Chiffon Dress']");
	public static By Cart_box = By.xpath("//a[@title='View my shopping cart']");
	public static By remove_button = By.xpath("//dt[@data-id= 'cart_block_product_1_1_0']/span");
	
	public Products_PO(WebDriver driver, WebDriverWait wait, Scenario Scn)
	{
		this.driver = driver;
		this.wait = wait;
		this.Scn = Scn;
//		action = new actions(this.driver, this.wait, this.Scn);
//		waitForElement =new WaitForElement(this.driver, this.wait);
	}
	
	public void Login(String Username , String Password)
	{
		action.click(login);
		action.SendText(mailId_Box , Username);
		action.SendText(Password_Box, Password);
		action.click(Signin);
		logger.info("Successfully login");
	}
	
	public void click_on_tShirt()
	{
		action.click(T_Shirt);
	}
	
	public void click_on_more()
	{
		action.moveToElement(Move);
		action.click(More);
	}
	
	public void send_a_friend()
	{
		action.click(send_a_friend);	
	}
	
	public void fill_details(String Friend_Name, String Email_id)
	{
		action.SendText(friend_name, Friend_Name);
		action.SendText(friend_email, Email_id);
		action.click(Send);
	}
	
	
	
//------------------------------------	Cart
	public void add_three_product()
	{
	
		action.moveToElement(P_1);
		action.click(product_1);
		waitForElement.waitForElementClickable(Continue_shopping);
		action.click(Continue_shopping);
		
		action.moveToElement(P_2);
		action.click(product_2);
		waitForElement.waitForElementClickable(Continue_shopping);
		action.click(Continue_shopping);
		
		action.moveToElement(P_3);
		action.click(product_3);
		waitForElement.waitForElementClickable(Continue_shopping);
		action.click(Continue_shopping);
		logger.info("Add 3 products successfully");
	}
	
	public void validate_cart_value()
	
	{
		action.moveToElement(Cart_qnty);
		waitForElement.waitForElementVisibilityOfElementLocated(Cart_qnty);
		String CartValue = driver.findElement(Cart_qnty).getText();
		Assert.assertEquals("cart value is inccorrect",CartValue, "3");
	}
	
	public void remove_cart_value()
	{
		action.moveToElement(Cart_box);
		waitForElement.waitForElementVisibilityOfElementLocated(Cart_box);
		action.click(remove_button);
		waitForElement.Wait_KiloBytes();
		String CartValue = driver.findElement(Cart_qnty).getText();
		Assert.assertEquals("cart value is inccorrect",CartValue, "2");
	}
	
	
}
