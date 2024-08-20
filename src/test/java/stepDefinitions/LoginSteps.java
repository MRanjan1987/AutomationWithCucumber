package stepDefinitions;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import utils.DataDriven;
import utils.ScreenshotUtils;

public class LoginSteps {
	WebDriver driver;
	LoginPage loginPage;

//Scenario: Successful login with valid credentials

	@Given("User is on login page {string}")
	public void user_is_on_login_page(String url) {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get(url);
		loginPage = new LoginPage(driver);

	}

	@Test(dataProvider = "loginData", dataProviderClass = DataDriven.class)
	@When("User enters {string} and {string}")
	public void user_enters_username_and_password(String username, String password){
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);

	}

	@And("Click on Login or Submit button")
	public void click_on_login_or_submit_button() {
		loginPage.clickLoginButton();
	}

	@Then("User should be logged in successfully")
	public void user_should_be_logged_in_successfully() {
		String expectedUrl = "https://practice.expandtesting.com/secure";
		assertEquals(expectedUrl, driver.getCurrentUrl());
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
