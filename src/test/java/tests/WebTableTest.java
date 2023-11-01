package tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class WebTableTest {

	static WebDriver driver;

	@SuppressWarnings("deprecation")
	@Test
	public void f() {

		driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement table = driver.findElement(By.name("BookTable"));
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int rowCount = rows.size();

		System.out.println("rowCount " + rowCount);

		List<WebElement> headerValues = rows.get(0).findElements(By.tagName("th"));
		int columnCount = headerValues.size();

		System.out.println("columnCount " + columnCount);

//		List<WebElement> cells = rows.get(0).findElements(By.tagName("td"));
//
//		for (WebElement cell : cells) {
//			String cellDate = cell.getText();
//			System.out.println("cellDate" + cellDate);
//		}

		for (int row = 1; row < rowCount; row++) {

			List<WebElement> cells = rows.get(row).findElements(By.tagName("td"));

			for (int col = 0; col < columnCount; col++) {
				String data = cells.get(col).getText();
				System.out.print(data + "\t");
			}
			
			System.out.println();
		}
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();

	}
}
