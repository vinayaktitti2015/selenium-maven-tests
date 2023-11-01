package exceptions;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class Exceptions {

	static WebDriver driver;

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-exceptions/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void testNoSuchElementException() {
		driver.findElement(By.id("add_btn")).click();

		try {

			// Thread.sleep(10000);
			WebElement row2 = driver.findElement(By.xpath("(//input[@type='text'])[2]"));

			// WebDriverWait wait = new WebDriverWait(driver, 20);

			// explicit wait
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(d -> row2.isDisplayed());
			Assert.assertTrue(row2.isDisplayed());

		} catch (Exception e) {
			System.out.print(e);
		}

	}

	@Test
	public void testElementNotInteractableException() {
		driver.findElement(By.id("add_btn")).click();

		try {

			// Thread.sleep(10000);
			WebElement row2 = driver.findElement(By.xpath("(//input[@type='text'])[2]"));

			// WebDriverWait wait = new WebDriverWait(driver, 20);

			// explicit wait
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(d -> row2.isDisplayed());
			Assert.assertTrue(row2.isDisplayed());

			row2.sendKeys("Test");
			driver.findElement(By.xpath("(//*[@name=\"Save\"])[2]")).click();

		} catch (Exception e) {
			System.out.print(e);
		}

	}

	@Test
	public void testInvalidStateElementException() {
		try {

			// Thread.sleep(10000);
			WebElement row1 = driver.findElement(By.cssSelector(".input-field"));

			// WebDriverWait wait = new WebDriverWait(driver, 20);

			// explicit wait
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(d -> row1.isDisplayed());
			Assert.assertTrue(row1.isDisplayed());

			// driver.findElement(By.xpath("(//*[@name=\"Save\"])[2]")).click();

			driver.findElement(By.id("edit_btn")).click();
			row1.clear();
			row1.sendKeys("Muffin");
			driver.findElement(By.id("save_btn")).click();

			WebElement element = driver.findElement(By.xpath("//*[contains(text(), 'Row 1 was saved')]"));
			
			Wait<WebDriver> wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait2.until(d -> element.isDisplayed());
			Assert.assertEquals(element.getText(), "Row 1 was saved");

		} catch (Exception e) {
			System.out.print(e);
		}

	}
	
	
	@Test
	public void testInvalidStateElementExceptionUsingJavascript() {
		try {

			// Thread.sleep(10000);
			WebElement row1 = driver.findElement(By.cssSelector(".input-field"));
			
			// explicit wait
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			wait.until(d -> row1.isDisplayed());
			Assert.assertTrue(row1.isDisplayed());

			// javascript
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("arguments[0].removeAttribute('disabled')", row1);
			
			row1.clear();
			row1.sendKeys("Muffin");
			

		} catch (Exception e) {
			System.out.print(e);
		}

	}
	
	@Test
	public void testTimeoutException() {
		driver.findElement(By.id("add_btn")).click();

		try {

			// Thread.sleep(10000);
			WebElement row2 = driver.findElement(By.xpath("(//input[@type='text'])[2]"));

			// WebDriverWait wait = new WebDriverWait(driver, 20);

			// explicit wait
			Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(d -> row2.isDisplayed());
			Assert.assertTrue(row2.isDisplayed());

			row2.sendKeys("Test");
			driver.findElement(By.xpath("(//*[@name=\"Save\"])[2]")).click();

		} catch (Exception e) {
			System.out.print(e);
		}

	}

	@AfterMethod
	public void afterMethod() {
		driver.quit();
	}

}
