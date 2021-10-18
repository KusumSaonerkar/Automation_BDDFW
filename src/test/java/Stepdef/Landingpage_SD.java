package Stepdef;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.TestContext;
import Base.WebDriverFactory;
import PageObject.Landingpage_PO;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Landingpage_SD extends TestContext

{
//	WebDriver driver;
//	WebDriverWait wait;
	//Scenario scn;
	//Landingpage_PO landingpage;
	
	public Scenario scn;
	protected TestContext testContext;

	public Landingpage_SD(TestContext testContext) 
	{
		this.testContext = testContext;
		this.scn = testContext.scn;		
	}
	
	@Before
	public void setup(Scenario scn)
	{
		this.scn = scn;
	}
	
	@Given("User open the browser")
	public void user_open_the_browser() throws Exception 
	{
		initializeWebDriver();
	    intializePageObjects(scn);
	    Base.WebDriverFactory.navigateToTheUrl(base_url);
	    
		/* 
		 * driver = new ChromeDriver(); driver.manage().window().maximize();
		 * driver.manage().deleteAllCookies();
		 * driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 * driver.get("http://automationpractice.com/index.php");
		 */
		//landingpage = new Landingpage_PO(driver, wait, scn);
	}

	@When("User can display  the product category")
	public void user_can_display_the_product_category() 
	{
	   landingpage.allCategoryDisplayed();
	}


	@When("User click on youtube icon")
	public void user_click_on_youtube_icon()
	{
		landingpage.youtube();
	}
	

	@Then("user nevigate to youtube page {string}")
	public void user_nevigate_to_youtube_page(String youtubechannelname) 
	{
	   Assert.assertEquals("channel name is incorrect",youtubechannelname, driver.findElement(By.xpath("//div[@id = 'text-container']/child::yt-formatted-string[text() = 'Selenium Framework']")).getText());
	}
	
	@When("User click on facebook icon")
	public void user_click_on_facebook_icon() 
	{
	    landingpage.facebook();
	}


	@Then("User nevigte to facebook page {string}")
	public void user_nevigte_to_facebook_page(String facebookpagename) 
	{
	   Assert.assertEquals("page name is incorrect",facebookpagename, driver.findElement(By.xpath("//h1[@dir = 'auto']//span[@dir = 'auto']/div[text() = 'Selenium Framework']")).getText());
	}

	
	
	@When("User click on twitter icon")
	public void user_click_on_twitter_icon() 
	{
	    landingpage.twitter();
	}


	@Then("User nevigte to twitter page {string}")
	public void user_nevigte_to_twitter_page(String twitterhandlename) 
	{
	    Assert.assertEquals("Handle name is incorrect",twitterhandlename, driver.findElement(By.xpath("//div[@class = 'css-1dbjc4n r-1awozwy r-xoduu5 r-18u37iz r-dnmrzs']//span[text() = 'Selenium Framework']")).getText());

	}


	@Then("User close the browser")
	public void user_close_the_browser() 
	{
		WebDriverFactory.quitDriver();
	}
}
