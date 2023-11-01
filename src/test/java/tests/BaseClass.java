package tests;

import org.testng.annotations.Test;

import config.BrowserFactory;
import config.ReadProperty;
import constants.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;

public class BaseClass {

	static WebDriver driver;

	ReadProperty prop = new ReadProperty();

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("Call before suite");
		// db connection
	}

	@BeforeTest
	public void beforeTest() {
		System.out.println("Call before test");
		// make an API call
	}
	
	@SuppressWarnings("deprecation")
	@BeforeMethod(groups="regressiontest")
	public void beforeMethod2() throws IOException {
		// UI automation
		driver = BrowserFactory.openBrowser(prop.getKey("browser"));
		driver.get(prop.getKey("baseurl"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // implicit wait
	}
	
	@AfterMethod(groups="regressiontest")
	public void afterMethod() {
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		System.out.println("Call after test suite");
		// api calls or other configuration
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("Call after suite");
		// close the db connection
	}

}
