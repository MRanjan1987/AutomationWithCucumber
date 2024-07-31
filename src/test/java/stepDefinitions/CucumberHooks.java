package stepDefinitions;

import static utils.WebDriverUtils.getDriver;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import utils.ScreenshotUtils;

public class CucumberHooks {

	private WebDriver driver;

	public CucumberHooks() {
		this.driver = getDriver();
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// Wait for the page to fully load
			new WebDriverWait(driver, Duration.ofSeconds(10)).until(webDriver -> ((JavascriptExecutor) webDriver)
					.executeScript("return document.readyState").equals("complete"));

			// Optionally, wait for specific elements to be visible
			// new WebDriverWait(driver, Duration.ofSeconds(10))
			// .until(ExpectedConditions.visibilityOfElementLocated(By.id("yourElementId")));

			// Take screenshot
			final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", "screenshot");

			// Save screenshot to file system
			ScreenshotUtils.takeScreenshot(driver, scenario.getName());
		}

	}
}
