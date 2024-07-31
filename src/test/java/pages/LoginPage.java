package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	WebDriver driver;

	@FindBy(id = "username")
	WebElement usernameField;

	@FindBy(id = "password")
	WebElement passwordField;

	@FindBy(xpath = "//*[@id='login']//button[contains(text(),'Login')]")
	WebElement loginButton;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterUsername(String username) {
		usernameField.sendKeys(username);
	}

	public void enterPassword(String password) {
		passwordField.sendKeys(password);
	}

	public void clickLoginButton() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for visibility and clickable state
		wait.until(ExpectedConditions.visibilityOf(loginButton));
		wait.until(ExpectedConditions.elementToBeClickable(loginButton));

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", loginButton);

		// Attempt click using JavaScript
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", loginButton);
	}

	@FindBy(xpath = "//b[normalize-space()='You logged into a secure area!']")
	public WebElement verifyLandingPage;

	public void HomePageVerification() {

		String text = verifyLandingPage.getText();
		Assert.assertEquals(text, "You logged into a secure area!", "Page not navigated to homepage");
	}
}
