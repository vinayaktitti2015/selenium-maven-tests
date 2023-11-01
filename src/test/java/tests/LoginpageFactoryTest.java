package tests;

import org.testng.annotations.Test;

import pageobjects.LoginPageFactory;

public class LoginpageFactoryTest extends BaseClass {

	LoginPageFactory page;

	@Test
	public void testValidLogin() {
		page = new LoginPageFactory(driver);
		page.enterUsername("Admin");
		page.enterPassword("admin123");
		page.clickLogin();
		page.verifyDashboard("Dashboard");
	}

	@Test
	public void testLoginDirectFunction() {
		page = new LoginPageFactory(driver);
		page.userLogin("Admin", "admin123", "Dashboard");
	}

	@Test(dependsOnMethods = { "testValidLogin" })
	public void testLoginwithInValidUsername() {
		page = new LoginPageFactory(driver);
		page.enterUsername("Admin3434");
		page.enterPassword("admin123");
		page.clickLogin();
		page.verifyGenericErrorMessage("Invalid credentials");
	}

	@Test(dependsOnMethods = { "testLoginDirectFunction" })
	public void testLoginwithInValidPassword() {
		page = new LoginPageFactory(driver);
		page.enterUsername("Admin");
		page.enterPassword("admin1234");
		page.clickLogin();
		page.verifyGenericErrorMessage("Invalid credentials");
	}

	@Test(enabled = false)
	public void testLoginwithBlankCredentials() {
		page = new LoginPageFactory(driver);
		page.enterUsername("");
		page.enterPassword("");
		page.clickLogin();
		page.verifyUsernameErrorMessage("Required");
		page.verifyPasswordErrorMessage("Required");
	}
}
