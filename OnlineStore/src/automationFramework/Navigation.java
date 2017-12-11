package automationFramework;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Navigation {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {

		//Allows instance of driver to be created and used.
		System.setProperty("webdriver.gecko.driver", "C:\\Automation\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		//Converts a page into a string and driver calls it to open
		String url = "http://toolsqa.wpengine.com/automation-practice-form/";
		driver.get(url);
		
		//Enters first and last name into two boxes by locating the name tag in HTML.
		driver.findElement(By.name("firstname")).sendKeys("Yaneez");
		driver.findElement(By.name("lastname")).sendKeys("Lowtun");
		//driver.findElement(By.id("submit")).click();
		
		//driver.findElement(By.partialLinkText("Partial")).click();
		String button = driver.findElement(By.tagName("button")).toString();
		
		System.out.println(button);
		

		/*Creates a list of elements that contain the name tag "sex". Then checks if the second radio button
		is ticked; if not, then select it.*/
		List<WebElement> radButtons = driver.findElements(By.name("sex"));
		boolean value = false;
		value = radButtons.get(1).isSelected();
		  if (value == true) {
			radButtons.get(0).click();
		} else {
			radButtons.get(1).click();
		}
		
		//Finds the radio button by id tag and clicks it.
		WebElement expBtn = driver.findElement(By.id("exp-2"));
		expBtn.click();
		
		
		List<WebElement> boxes = driver.findElements(By.name("profession"));	
		int size = boxes.size();
		
		for(int i=0; i < size; i++) {
			
			String boxValue = boxes.get(i).getAttribute("value");
			
			if(boxValue.equals("Automation Tester")) {
				boxes.get(i).click();
				
				break;
			}
		}
		
		//declares toolBox as an element finds the value of the check box and clicks it.
		WebElement toolBox = driver.findElement(By.cssSelector("input[value='Selenium IDE']"));
		toolBox.click();
		
		//Selects a drop-down menu by the ID and puts it into a list.
		Select cSelect = new Select(driver.findElement(By.id("continents")));
		List<WebElement> elementCount = cSelect.getOptions();
		
		//Selects the second option in menu by position(index) then waits and selects Africa by it's text.
		cSelect.selectByIndex(1);
		Thread.sleep(2000);
		cSelect.selectByVisibleText("Africa");
		
		
		//Creates a variable containing size of List.
		int iSize = elementCount.size();
		//Uses the list to print out all items in the list.
		for(int i = 0; i < iSize; i++ )
		{
			String item = elementCount.get(i).getText();
			System.out.println(item);
		//Checks look until Antartica is found then selects it by its visible text attribute.
			if(item.equals("Antartica"))
			{
				cSelect.selectByVisibleText(item);
			}
		}
		
		Select mSelect = new Select(driver.findElement(By.name("selenium_commands")));
		
		mSelect.selectByIndex(0);
		Thread.sleep(3000);
		mSelect.deselectByIndex(0);
		Thread.sleep(3000);
		mSelect.selectByVisibleText("Navigation Commands");
		Thread.sleep(3000);
		mSelect.deselectByVisibleText("Navigation Commands");
		Thread.sleep(3000);
		
		List<WebElement> mSize = mSelect.getOptions();
		int mListSize = mSize.size();
		
		for(int i=0; i<mListSize; i++)
		{
			mSelect.selectByIndex(i);
			String m = mSize.get(i).getText();
			System.out.println(m);
		}
		
		mSelect.deselectAll();
		
		Thread.sleep(5000);
	
		
		
		driver.close();
		
		WebDriver driver2 = new FirefoxDriver();
		driver2.get("http://toolsqa.wpengine.com/automation-practice-table/");
		
		//String cellValue = driver2.findElement(By.xpath(xpathExpression));
		
	}

}
