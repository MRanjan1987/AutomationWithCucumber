package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PracticeFormPage extends BasePage {
	public PracticeFormPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
	}

	@FindBy(xpath = "//input[@id='name']")
	WebElement username;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='phon']")
	WebElement phone;
	@FindBy(xpath = "//textarea[@id='textarea']")
	WebElement address;

	public void enterUserName(String name) {
		// username.sendKeys(name);
		js.executeScript("arguments[0].value=arguments[1];", username, name);
	}

	public void enterEmail(String mail) {
		// email.sendKeys(mail);
		js.executeScript("arguments[0].value=arguments[1];", email, mail);
	}

	public void enterPhone(String pNo) {
		// phone.sendKeys(pNo);
		js.executeScript("arguments[0].value=arguments[1];", phone, pNo);
	}

	public void enterAddress(String add) {
		// address.sendKeys(add);
		js.executeScript("arguments[0].value=arguments[1];", address, add);
	}

}
