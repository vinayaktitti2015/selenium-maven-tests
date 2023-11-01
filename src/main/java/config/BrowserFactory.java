package config;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;

public class BrowserFactory {

	public class openBrowser implements WebDriver {

		@Override
		public void get(String url) {
			// TODO Auto-generated method stub

		}

		@Override
		public String getCurrentUrl() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getTitle() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public List<WebElement> findElements(By by) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public WebElement findElement(By by) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getPageSource() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void close() {
			// TODO Auto-generated method stub

		}

		@Override
		public void quit() {
			// TODO Auto-generated method stub

		}

		@Override
		public Set<String> getWindowHandles() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String getWindowHandle() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public TargetLocator switchTo() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Navigation navigate() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public Options manage() {
			// TODO Auto-generated method stub
			return null;
		}

	}

	public static WebDriver driver;

	public static WebDriver openBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-extensions");
			options.addArguments("--disable-notifications");
			options.addArguments("--enable-automation");
			options.addArguments("--disable-infobars");
			options.addArguments("--start-maximized");
			
			setDriver(new ChromeDriver(options));
		} else if(browser.equalsIgnoreCase("firefox")) {
			setDriver(new FirefoxDriver());
		} else if(browser.equalsIgnoreCase("msedge")) {
			EdgeOptions options = new EdgeOptions();
			options.addArguments("--start-maximized");
			
			setDriver(new EdgeDriver(options));
		} else if(browser.equalsIgnoreCase("safari")) {
			SafariOptions options = new SafariOptions();
			options.setCapability("session.cleanSession", true);
			options.setCapability("--start-maximized", true);
			setDriver(new SafariDriver());
		}
		
		return getDriver();
	}

	private static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}

	private static void setDriver(WebDriver driver) {
		// TODO Auto-generated method stub
		BrowserFactory.driver = driver;
	}

}
