package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
	WebDriver driver;
	LoginPage loginPage;

	@Before
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
	}

//Scenario: Successful login with valid credentials
	@Given("the user is on the login page")
	public void the_user_is_on_the_login_page() {
		driver.get("https://practice.expandtesting.com/login");
	}

	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
		loginPage.clickLoginButton();
	}

	@When("the user enters a valid username and password")
	public void the_user_enters_a_valid_username_and_password() {
		loginPage.enterUsername("practice");
		loginPage.enterPassword("SuperSecretPassword!");
	}

	@Then("the user should be redirected to the homepage")
	public void the_user_should_be_redirected_to_the_homepage() {
		String currentUrl = driver.getCurrentUrl();

		assertEquals("https://practice.expandtesting.com/secure", currentUrl);
	}

	@Then("a welcome message should be displayed")
	public void a_welcome_message_should_be_displayed() {
		WebElement welcomeMessage = driver
				.findElement(By.xpath("//b[contains(text(),'You logged out of the secure area!')]"));
		assertTrue(welcomeMessage.isDisplayed());

	}

//Scenario: Unsuccessful login with invalid credentials//
	@When("the user enters an invalid username and password")
	public void the_user_enters_an_invalid_username_and_password() {
		loginPage.enterUsername("invalidUsername");
		loginPage.enterPassword("invalidPassword");
	}

	@Then("an error message should be displayed")
	public void an_error_message_should_be_displayed() {
		WebElement errorMessage = driver
				.findElement(By.xpath("//div[@id='flash' and contains(text(),'Your username is invalid!')]"));
		assertTrue(errorMessage.isDisplayed());
	}

	@Then("the user should remain on the login page")
	public void the_user_should_remain_on_the_login_page() {
		String currentUrl = driver.getCurrentUrl();
		assertEquals("https://practice.expandtesting.com/login", currentUrl);
	}

	// ***
	@When("the user enters an empty username and a valid password")
	public void the_user_enters_an_empty_username_and_a_valid_password() {
		loginPage.enterUsername("");
		loginPage.enterPassword("SuperSecretPassword!");
	}

	@When("the user enters a valid username and an empty password")
	public void the_user_enters_a_valid_username_and_an_empty_password() {
		loginPage.enterUsername("practice");
		loginPage.enterPassword("");
	}

	@When("the user enters an empty username and an empty password")
	public void the_user_enters_an_empty_username_and_an_empty_password() {
		loginPage.enterUsername("");
		loginPage.enterPassword("");
	}

	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
