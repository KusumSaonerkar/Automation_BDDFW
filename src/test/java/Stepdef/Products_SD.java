package Stepdef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.TestContext;
import Base.WebDriverFactory;
import PageObject.Products_PO;
import Utilities.actions;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Products_SD extends TestContext
{
//	WebDriver driver;
//	WebDriverWait wait;
//	Scenario Scn;
//	actions action;
	//Products_PO Product;
	
	@Given("open the browser")
	public void open_the_browser() throws Exception 
	{
		initializeWebDriver();
	    intializePageObjects(scn);
	    Base.WebDriverFactory.navigateToTheUrl(base_url);
//		driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
//		//wait = new WebDriverWait(driver, 40);
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("http://automationpractice.com/index.php");
		//Product = new Products_PO(driver, wait, Scn);
	}

	
	@When("User login username {string} and password {string}")
	public void user_login_username_and_password(String Username, String Password) 
	{
	    Product.Login(Username, Password);
	}

	@Then("User clicked on T-shirts catgory")
	public void user_clicked_on_t_shirts_catgory() 
	{
	    Product.click_on_tShirt();
	}
	
	@Then("User clicked on more")
	public void user_clicked_on_more() 
	{
		Product.click_on_more();
	}
	
	@Then("User clicked on Send a friend")
	public void user_clicked_on_send_a_friend() 
	{
	    Product.send_a_friend();
	}
	
	@Then("User fill the details {string} and {string} and clicked on send button")
	public void user_fill_the_details_and_and_clicked_on_send_button(String Friend_Name, String Email_id) 
	{
	    Product.fill_details(Friend_Name, Email_id);
	    String Message = "Your e-mail has been sent successfully";
	    Assert.assertEquals("unable to send request", Message , driver.findElement(By.xpath("//p[text() = 'Your e-mail has been sent successfully']")).getText());
	}
	
	@When("user add three product in cart")
	public void user_add_three_product_in_cart() 
	{
	    Product.add_three_product();
	}


	@Then("user validate the cart product value")
	public void user_validate_the_cart_product_value() 
	{
	    Product.validate_cart_value();
	}
	
	@Then("user validate the remove cart product value")
	public void user_validate_the_remove_cart_product_value() 
	{
	    Product.remove_cart_value();
	}


	
	@Then("close the browser")
	public void close_the_browser()
	{
		WebDriverFactory.quitDriver();
	    
	}




}
