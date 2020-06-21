package CloudThing.Assignment;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SetupTestChrome {
	
	WebDriver driver;
	
	@BeforeMethod
	public void init() throws InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "src/main/resourses/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		Thread.sleep(6000);
		driver.get("www.Amazon.in");
		
	}
	
	@Test
	public void chromeTest()
	{
		System.out.println("test Passed");
	}

}
