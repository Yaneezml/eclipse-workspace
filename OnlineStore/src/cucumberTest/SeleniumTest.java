package cucumberTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new FirefoxDriver();
		
		String url = "http://www.store.demoqa.com";
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);
		
		driver.findElement(By.linkText("Home")).click();
		System.out.println("Navigated to home page");
		
		driver.findElement(By.className("account_icon")).click();
		System.out.println("Naviation to My Account log-in page successful");
		
		driver.findElement(By.xpath("//*[@id=\"log\"]")).sendKeys("Yaneezml");
		driver.findElement(By.xpath("//*[@id=\"pwd\"]")).sendKeys("uz*um&M64hx*XAwI");
		
		WebElement inputBox = driver.findElement(By.id("log"));

		
		if (inputBox.getAttribute("value").isEmpty())
		{

			System.out.println("Input field is empty!");
			Thread.sleep(2000);
			driver.quit();	
		}
		else
		{
			System.out.println("Usename and password entered.");
		}
		
		driver.findElement(By.name("submit")).click();
		System.out.println("Log-in button has been pressed");
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Log out"))).click();
		System.out.println("Logged out successfully");
		Thread.sleep(3000);
		driver.quit();
		
	}

}
