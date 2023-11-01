package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageDesign2 {

	 WebDriver driver;

	public LoginPageDesign2(WebDriver driver) {
		this.driver = driver;

	}
	
	// Fluent Page Object Model
	private By usernameInput = By.name("username");
	private By passwordInput = By.name("password");
	private By loginButton = By.cssSelector("[type=\"submit\"]");
	private By dashboardLabel = By.cssSelector(".oxd-topbar-header-breadcrumb-module");

	public void enterUsername(String username) {
		driver.findElement(usernameInput).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordInput).sendKeys(password);
	}

	public void clickLogin() {
		driver.findElement(loginButton).click();
	}

	public void verifyDashboard(String expected) {
		String actual = driver.findElement(dashboardLabel).getText();
		Assert.assertEquals(actual, expected);
	}

	public void userLogin(WebDriver driver, String username, String password, String expected) {
		driver.findElement(usernameInput).sendKeys(username);
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginButton).click();
		String actual = driver.findElement(dashboardLabel).getText();
		Assert.assertEquals(actual, expected);
	}

}
