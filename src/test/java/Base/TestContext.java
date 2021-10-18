package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageObject.Landingpage_PO;
import PageObject.Products_PO;
import Utilities.ScreenShot;
import Utilities.WaitForElement;
import Utilities.actions;
import io.cucumber.java.Scenario;

public class TestContext 

{
	    public WebDriver driver;
	    public WebDriverWait wait;
	    public Scenario scn;
	    public String base_url = "http://automationpractice.com/index.php?";
	    public int implicit_wait_timeout_in_sec = 40;
	    
	 
	    
	    public static actions action;
	    public static WaitForElement waitForElement ;
	    public static Landingpage_PO landingpage;
	    public static Products_PO Product;
	    public static ScreenShot screenshot;
	   
	    public void initializeWebDriver() throws Exception 
	    {
	        //Get the browser name by default it is chrome
	        String browserName = WebDriverFactory.getBrowserName();
	        driver = WebDriverFactory.getWebDriverForBrowser(browserName);
	       
	       // logger.info("Browser invoked.");
	    }   
	    
	 public void intializePageObjects(Scenario scn)
	 {
		 
		 this.scn = scn;
		 wait = new WebDriverWait(driver, 40);
		 action = new actions(driver, wait, scn);
		 waitForElement = new WaitForElement(this.driver, this.wait);
		 landingpage = new Landingpage_PO(driver, wait, scn);
		 Product = new Products_PO(driver, wait, scn);
		 screenshot = new ScreenShot(driver, scn, wait);
				 																
	 }
	 
	 

}
