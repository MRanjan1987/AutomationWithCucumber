package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScreenshotUtils {

	public static String takeScreenshot(WebDriver driver, String screenshotName) {
		// Wait for the page to fully load
		new WebDriverWait(driver, Duration.ofSeconds(10)).until(webDriver -> ((JavascriptExecutor) webDriver)
				.executeScript("return document.readyState").equals("complete"));

		// Sanitize the screenshot name
		screenshotName = sanitizeFileName(screenshotName);

		// Take the screenshot
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationDir = "target/screenshots/";
		String destination = destinationDir + screenshotName + ".png";

		// Create the directory if it doesn't exist
		File directory = new File(destinationDir);
		if (!directory.exists()) {
			directory.mkdirs();
		}

		try {
			FileHandler.copy(source, new File(destination));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destination;
	}

	// Method to scroll to a specific element before taking a screenshot
	public static void scrollToElement(WebDriver driver, WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// Sanitize the file name to remove invalid characters
	public static String sanitizeFileName(String fileName) {
		return fileName.replaceAll("[^a-zA-Z0-9-_\\.]", "_");
	}
}
