package myapp;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Que4 {
	public WebDriver driver;

	@BeforeClass
	public void launchBrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Utsav Sharma\\eclipse-workspace\\SeleniumAssignment3\\src\\test\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/");
	}

	@Test
	public void dragAndDropTest() {
		driver.findElement(By.xpath("//h5[text()=\"Interactions\"]")).click();
		driver.findElement(By.xpath("//li[@class=\"btn btn-light \"][4]")).click();
		WebElement dragTo = driver.findElement(By.id("draggable"));
		WebElement dropTo = driver.findElement(By.id("droppable"));
		Actions action = new Actions(driver);
		action.dragAndDrop(dragTo, dropTo);
	}

	@AfterClass
	public void ClosingBrowser() {
		driver.close();
	}
}
