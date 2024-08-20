package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import pages.BasePage;

public class BrowserEventUtility extends BasePage {

	public BrowserEventUtility(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void switch_Window_Tabs() {
		driver.switchTo().newWindow(WindowType.TAB);
	}

	public void switch_Full_Window() {
		driver.switchTo().newWindow(WindowType.WINDOW);
	}

}
