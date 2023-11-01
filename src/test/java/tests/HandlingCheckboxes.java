package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class HandlingCheckboxes {

	static WebDriver driver;

	@Test
	public void test() throws InterruptedException {
		// TODO Auto-generated method stub

		driver = new ChromeDriver();
		driver.get("https://www.globalsqa.com/samplepagetest/");

		// implicit wait
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// driver.manage().window().maximize();

		driver.findElement(By.id("g2599-name")).sendKeys("Arif Ahmad");
		driver.findElement(By.id("g2599-email")).sendKeys("test@yahoo.com");
		driver.findElement(By.id("contact-form-comment-g2599-comment")).sendKeys("test comments");

		// checkboxes
		// driver.findElement(By.xpath("(//*[@name=\"g2599-expertise[]\"])[1]")).click();
		// driver.findElement(By.xpath("(//*[@name=\"g2599-expertise[]\"])[2]")).click();
		// driver.findElement(By.xpath("(//*[@name=\"g2599-expertise[]\"])[3]")).click();

		List<WebElement> list = driver.findElements(By.xpath("//*[@name=\"g2599-expertise[]\"]"));

		for (WebElement ele : list) {
			boolean checkState = ele.isDisplayed();

			if (checkState == true) {

				Actions action = new Actions(driver);
				action.moveToElement(ele).click().build().perform();
			}

			boolean checkState2 = ele.isEnabled();

			if (checkState2 == true) {

				Actions action = new Actions(driver);
				action.moveToElement(ele).click().build().perform();
			}

			boolean checkState3 = ele.isSelected();

			if (checkState3 == false) {
				// check
				Actions action = new Actions(driver);
				action.moveToElement(ele).click().build().perform();
			} else if (checkState == true) {
				// uncheck
			}
		}

		Thread.sleep(5000);
		driver.findElement(By.className("pushbutton-wide")).click();

	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

}
