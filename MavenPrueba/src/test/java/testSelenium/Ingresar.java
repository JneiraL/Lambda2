package testSelenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Ingresar {
	
	static void Open() 
	{
		try {
			WebDriver driver;
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\jneira\\eclipse-workspace\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("https://www.linio.com.co/");
			driver.manage().window().maximize();
			Thread.sleep(5000);
			driver.navigate().refresh();
			Thread.sleep(3000);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
