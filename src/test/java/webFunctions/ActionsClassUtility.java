package webFunctions;

import org.openqa.selenium.Keys;
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

	public void selectAllByMouse() {

		doAction = action.keyDown(Keys.CONTROL).sendKeys("A").keyUp(Keys.CONTROL).build();
		doAction.perform();
	}

	public void copyByMouse() {

		doAction = action.keyDown(Keys.CONTROL).sendKeys("C").keyUp(Keys.CONTROL).build();
		doAction.perform();
	}

	public void tabByMouse() {

		doAction = action.keyDown(Keys.TAB).keyUp(Keys.TAB).build();
		doAction.perform();
	}

	public void pasteByMouse() {

		doAction = action.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).build();
		doAction.perform();
	}

	public void EnterByMouse() {

		doAction = action.keyDown(Keys.ENTER).keyUp(Keys.ENTER).build();
		doAction.perform();
	}
}
