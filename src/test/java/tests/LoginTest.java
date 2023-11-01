package tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import config.ReadProperty;
import constants.Constants;
import pageobjects.LoginPageDesign2;

public class LoginTest extends BaseClass {

	LoginPageDesign2 page = new LoginPageDesign2(driver);
	// Constants env = new Constants();
	ReadProperty env = new ReadProperty();

	@Test
	public void testUserLogin() throws IOException {

		page.userLogin(driver, env.getKey("username"), env.getKey("password"), env.getKey("dashboard"));
	}

}
