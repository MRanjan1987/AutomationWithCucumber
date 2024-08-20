package utils;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.BasePage;

public class JavaScriptUtilityFile {

	public void send_data_to_inputfields(WebElement element, String text, WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for visibility and clickable state
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].value=arguments[1];", element, text);

	}

	public void clickLoginButton(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		// Wait for visibility and clickable state
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.elementToBeClickable(element));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Scroll into view
		js.executeScript("arguments[0].scrollIntoView(true);", element);

		// Attempt click using JavaScript
		js.executeScript("arguments[0].click();", element);
	}

	public void Scroll_by_a_certain_amount_Horizontally(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1500)", "");

	}

	public void Scroll_to_a_specific_element(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);

	}

	public void Scroll_to_the_bottom_of_the_page(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

	}

	/****************************************************************************************************************/
	// 1) To type text in a text box
	public void typeText(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('Enter Id').value='text to be entered';");
	}

	// 2) To Click on a button:
	public void clickOnAButton(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].click();", element);
	}

	// 3) To Refresh the browser window/page
	public void refreshBrowser(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	// 4) To get the Domain Name

	public void getDomainName(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.domain;").toString();
	}

	// 5) To draw border around element

	public void draw_Border_Around_Element(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].style.border='3 px solid red';", element);
	}

	// 6) To get the title of web page

	public void get_WebPage_Title(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.title;").toString();
	}

	// 7) To get the url of webpage

	public void get_WebPage_URL(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.URL;").toString();
	}

	// 8) To Zoom Page

	public void zoom_page(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='50%'");
	}
	// 9) To get the Height and Width of the webPage

	public void getWebPage_Height(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return window.innerHeight;").toString();
	}

	public void getWebPage_Width(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return window.innerWidth;").toString();
	}
	// 10) To perform scroll on an application using selenium

	/* Scroll vertically till the end */
	public void scroll_Vertically_Down_Till_End(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	/* Scroll vertically till the end */
	public void scroll_Vertically_Up_Till_End(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
	}

	// 11) To generate Alert Pop Up window in selenium WebDriver

	public void Alert_PopUp_generate(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('Alert message.');");
	}

	// 12) To navigate to a different page using javascript

	public void navigate_WebPage(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location = 'URL'");
	}

	// example: js.executeScript("window.location = 'https://google.com'");

}
