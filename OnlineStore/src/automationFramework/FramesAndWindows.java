package automationFramework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FramesAndWindows {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.gecko.driver" , "C:\\Automation\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		String url = "http://demoqa.com/frames-and-windows/";
		driver.get(url);
		
		driver.findElement(By.xpath(".//*[@id=’tabs-1']/div/p/a")).click();
		
		Thread.sleep(5000);
		driver.close();
	}

}
