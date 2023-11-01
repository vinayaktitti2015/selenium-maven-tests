package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPageFactory {

	WebDriver driver;

	public LoginPageFactory(WebDriver driver) {
		// TODO Auto-generated constructor stub
		// this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	public WebElement usernameInput;

	@FindBy(name = "password")
	public WebElement passwordInput;

	@FindBy(css = "[type=\"submit\"]")
	public WebElement loginbutton;

	@FindBy(css = ".oxd-topbar-header-breadcrumb-module")
	public WebElement dashboardLabel;

	@FindBy(xpath = "(//*[contains(@class, 'oxd-input-field-error-message')])[1]")
	public WebElement usernameErrorMessage;

	@FindBy(xpath = "(//*[contains(@class, 'oxd-input-field-error-message')])[2]")
	public WebElement passwordErrorMessage;

	@FindBy(css = ".oxd-alert-content-text")
	public WebElement genericErrorMessage;

	// stateless functions
	public void enterUsername(String user) {
		usernameInput.clear();
		usernameInput.sendKeys(user);
	}

	public void enterPassword(String pass) {
		passwordInput.clear();
		passwordInput.sendKeys(pass);
	}

	public void clickLogin() {
		loginbutton.click();

	}

	public void verifyDashboard(String expected) {
		Assert.assertEquals(dashboardLabel.getText(), expected);
	}
	
	public void verifyUsernameErrorMessage(String message) {
		Assert.assertEquals(usernameErrorMessage.getText(), message);
	}
	
	public void verifyPasswordErrorMessage(String message) {
		Assert.assertEquals(passwordErrorMessage.getText(), message);
	}
	
	public void verifyGenericErrorMessage(String message) {
		Assert.assertEquals(genericErrorMessage.getText(), message);
	}

	// reusable function
	public void userLogin(String username, String password, String expected) {
		enterUsername(username);
		enterPassword(password);
		clickLogin();
		verifyDashboard(expected);
	}
}
