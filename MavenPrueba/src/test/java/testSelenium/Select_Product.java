package testSelenium;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Select_Product {
	
	static void Select_Prod()
	{
		try {
			WebDriver driver= new ChromeDriver();
		driver.findElement(By.id("open-left-menu")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".nav-link[title=\"Computación\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".banner-layout-4 [title=\"Desktops\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".catalogue-list [title=\"Monitores\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"catalogue-product-container\"]/div[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".product-quantity-container .select-dropdown")).click();
		Thread.sleep(2000);
		List<WebElement> Cantidades= driver.findElements(By.cssSelector(".select-dropdown-list li"));
		/*for (WebElement element : Cantidades) {
	        System.out.println("Paragraph text:" + element.getText());
	    }*/
		if(Cantidades.size()>=3) 
		{
			driver.findElement(By.cssSelector(".select-dropdown-list [data-value=\'2\']")).click();
		}else 
		{
			driver.findElement(By.cssSelector(".select-dropdown-list [data-value=\'1\']")).click();
		}
		String Preciouni=driver.findElement(By.cssSelector("#display-zoom .product-price .lowest-price")).getText();
		Preciouni=Preciouni.replace("$", "");
		Preciouni=Preciouni.replace(".", "");
		int Prec=Integer.parseInt(Preciouni);
		String Cantidad=driver.findElement(By.id("selected-option-product-quantity")).getText();
		int Cant=Integer.parseInt(Cantidad);
		driver.findElement(By.cssSelector(".product-price #buy-now")).click();
		Thread.sleep(3000);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
