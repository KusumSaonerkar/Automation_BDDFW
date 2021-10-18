package Utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import Base.TestContext;
import io.cucumber.java.Scenario;

public class ScreenShot extends TestContext

{
	private static final Logger logger = LogManager.getLogger(ScreenShot.class);
	Scenario scn;
	WebDriver driver;
	WebDriverWait wait;

	
	public ScreenShot(WebDriver driver, Scenario scn, WebDriverWait wait) {
		this.driver = driver;
		this.scn = scn;
		this.wait = wait;
	}

	public void ScreenShotOfFailedScenario(Scenario scn) {

		if (scn.isFailed()) {

			TakesScreenshot screenShot = (TakesScreenshot) driver;
			byte[] data = screenShot.getScreenshotAs(OutputType.BYTES);
			scn.attach(data, "image/png", "failed step name ::> " + scn.getName());
			logger.info("Test case isn't passed, screenShot is captured.");
		} else {
			scn.log("Test case is passed, No screenShot is captured.");
			logger.info("Test case is passed, No screenShot is captured.");
		}

	}
}
