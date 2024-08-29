package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utils.ExtentReportManager;
import utils.ScreenshotUtils;

public class Hooks {
	private static WebDriver driver;

	@Before
	public void setUp() {
		// Initialize WebDriver
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		// Set up Extent Reports
		ExtentReportManager.setUp();
		// Create a new test entry in the report
		ExtentReportManager.createTest("Cucumber Test");
	}

	@After
	public void tearDown(Scenario scenario) {
		if (scenario.isFailed()) {
			// Take screenshot on failure
			String[] screenshotPaths = ScreenshotUtils.takeScreenshot(driver, scenario.getName());
			String cucumberReportPath = screenshotPaths[0];
			String sparkReportPath = screenshotPaths[1];
			// String sparkReportPath =
			// "D:\\AutomationWorkspace\\Automation_Cucumber_BDD\\target\\SparkReport\\ExtentReport";

			// Attach the screenshot to the Extent Report
			// ExtentReportManager.getTest().addScreenCaptureFromPath(cucumberReportPath);

			// Optionally, you can also attach the screenshot from the Spark Report
			// directory if needed
			ExtentReportManager.getTest().addScreenCaptureFromPath(sparkReportPath);
		}

		// Quit WebDriver
		driver.quit();
		// Finalize the Extent Reports
		ExtentReportManager.tearDown();
	}

	public static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
}
