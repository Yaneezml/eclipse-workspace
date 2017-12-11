package automationFramework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class FirstTestCase {

	public static void main(String[] args) throws InterruptedException {

		DesiredCapabilities cap = DesiredCapabilities.firefox();
		cap.setCapability("marionette", true);
		System.setProperty("webdriver.gecko.driver", "C:\\Automation\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		String url = "http://www.store.DemoQA.com";
		driver.get(url);
		
		String title = driver.getTitle();
		int titleLength = title.length();
		
		System.out.println("Page title is: " + title);
		System.out.println("Title length is: " + titleLength);

		String realUrl = driver.getCurrentUrl();
		
		if (realUrl.equals(url))
		{
			System.out.println("URL matches!");
		} else
		{
			System.out.println("Incorrect URL!");
			System.out.println("real URL: " + realUrl);
			System.out.println("Expected URL: " + url);
		}
		
		String pageSource = driver.getPageSource();
		int pageLength = pageSource.length();
		
		System.out.println(pageLength);
		
		Thread.sleep(5000);
		driver.quit();
	}

}
