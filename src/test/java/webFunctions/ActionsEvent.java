package webFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import pages.BasePage;

public class ActionsEvent extends BasePage {
	private Actions action;
	private Action doAction;

	public ActionsEvent(WebDriver driver) {
		super(driver);
		action = new Actions(driver);

		// TODO Auto-generated constructor stub
	}

	public void right_Click(WebElement element) {

		doAction = action.contextClick(element).build();
		doAction.perform();
	}

	public void double_Click(WebElement element) {

		doAction = action.doubleClick(element).build();
		doAction.perform();
	}

	public void mouseHover(WebElement element) {

		doAction = action.moveToElement(element).build();
		doAction.perform();
	}

	public void mouseHover_By_co_ordinates(WebElement element, int xOffset, int yOffset) {

		doAction = action.moveToElement(element, xOffset, yOffset).build();
		doAction.perform();
	}

}
