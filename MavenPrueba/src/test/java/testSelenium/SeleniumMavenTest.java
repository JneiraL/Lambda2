package testSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumMavenTest {
	
	@Test
	public void ejecutarTest() throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jneira\\eclipse-workspace\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://www.google.com");
		Thread.sleep(5000);
		driver.close();
	}

}
