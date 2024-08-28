package stepDefinitions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.PracticeFormPage;
import utils.ScreenshotUtils;

public class PracticeFormSteps {
	WebDriver driver;
	PracticeFormPage practiceform;

	@Given("User is on landing page {string}")
	public void user_is_on_landing_page(String url) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);
		practiceform = new PracticeFormPage(driver);
	}

	@When("Enter name: {string}, email: {string}, phone: {string}, address: {string}")
	public void enter_name_email_phone_address(String uname, String emailid, String pno, String addr) {
		practiceform.enterUserName(uname);
		practiceform.enterEmail(emailid);
		practiceform.enterPhone(pno);
		practiceform.enterAddress(addr);
	}

	@Then("Verify the success message")
	public void verify_gthe_success_message() {

		System.out.println("Form submitted");
		driver.quit();
	}
	
	@AfterStep
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
