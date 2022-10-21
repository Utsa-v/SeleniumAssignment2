package myapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Que2 {
	public WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Utsav Sharma\\eclipse-workspace\\SeleniumAssignment3\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
	}

	@Test(priority=1)
	public void performingOperationTest() {
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).isSelected();
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value=\"DEL\"]")).click();
		driver.findElement(By.xpath("(//a[@value=\"BOM\"])[2]")).click();
		//driver.findElement(By.cssSelector("Ii-state-default.ui-state-highlight.ui-state-active")).click();
	}
	
	@Test(priority=2)
	public void selectPassengerAndSearch() {
		driver.findElement(By.id("divpaxinfo")).click();
		//adding three adults
		for(int i=0; i<3; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.xpath("//input[@value=\"Done\"]")).click();
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
	}
	
	
	@AfterClass
	public void closeBrowser() {
		driver.close();
	}

}