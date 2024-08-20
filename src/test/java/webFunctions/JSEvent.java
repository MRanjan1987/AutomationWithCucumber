package webFunctions;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class JSEvent extends BasePage {

	public JSEvent(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void send_data_to_inputfields(WebElement element, String text) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for visibility and clickable state
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].value=arguments[1];", element, text);

	}

	public void clickLoginButton(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for visibility and clickable state
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));

		// Scroll into view
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		// Attempt click using JavaScript
		js.executeScript("arguments[0].click();", element);
	}

	public void scrollPageByPixel() {
		js.executeScript("window.scrollBy(0,1500)", "");
		
	}
}
