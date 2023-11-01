package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPageDesign1 {
	
	private WebDriver driver;
	
	private WebElement username;
	private WebElement password;
	private WebElement loginButton;
	private WebElement dashboardLabel;
	
	public LoginPageDesign1(WebDriver driver) {
		this.driver = driver;
		
		username = driver.findElement(By.name("username"));
		password = driver.findElement(By.name("password"));
		loginButton = driver.findElement(By.cssSelector("[type=\"submit\"]"));
		dashboardLabel = driver.findElement(By.className(".oxd-topbar-header-breadcrumb-module"));
	}
	
	public void enterUsername(String username) {
		password.sendKeys();
	}
	
	public void enterPassword(String password) {
		// password.sendKeys(password);
	}


}
