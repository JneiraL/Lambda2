package testSelenium;

import java.util.List;

import org.omg.CORBA.SystemException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class SeleniumMaven {
	
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jneira\\eclipse-workspace\\drivers\\chromedriver.exe");
		driver.get("https://www.linio.com.co/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);
		System.out.println(driver.getTitle());
		
		
		//Ingresar.Open();
		//Select_Product.Select_Prod();
		
		
		/*driver.findElement(By.cssSelector(".col-md-4.quantity-icon-wrapper[data-dropdown-menu=\"user-menu\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".header-menu [href=\"/account/login\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".nav-item [href=\"#register-form\"]")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.id("registration_firstName")).sendKeys("Johan");
		driver.findElement(By.id("registration_lastName")).sendKeys("Neira");
		driver.findElement(By.id("registration_email")).sendKeys("bac@gmail.com");
		driver.findElement(By.id("registration_password")).sendKeys("Temporal123*");
		driver.findElement(By.cssSelector(".form-label[for='registration_acceptTerms']")).click();
		Thread.sleep(3000);
		driver.findElement(By.cssSelector(".btn-security[ng-disabled=\"!registration.$valid\"]")).click();
		*/
		
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
		List<WebElement> Cantidades=driver.findElements(By.cssSelector(".select-dropdown-list li"));
		
		for (WebElement element : Cantidades) {
            System.out.println("Paragraph text:" + element.getText());
        }
		
		if(Cantidades.size()>3) 
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
		
		//-----------------------------------------------------------------------------------------------------------
		
		String Mensaje=driver.findElement(By.xpath("//*[@id=\"alert-add-to-cart\"]/div/div/div[1]/div/h2[1]")).getText();
		String Mensajeok="Tu producto se agregó al carrito";
		if(Mensaje.equalsIgnoreCase(Mensajeok)) 
		{
			System.out.println("Mensaje validado");
			driver.findElement(By.cssSelector(".modal-dialog-fluid.success .alert-body [href=\"/cart\"]")).click();
			Thread.sleep(3000);
			String TotalStr=driver.findElement(By.cssSelector(".summary-total [class='price-main-md pull-xs-right']")).getText();
			String Envio=driver.findElement(By.xpath("//li//span[@class='price-base-md pull-xs-right shipping-price']")).getText();
			Envio=Envio.replace("$", "");
			Envio=Envio.replace(".", "");
			int Enviosum;
			if(Envio.equalsIgnoreCase("Envío gratis")) 
			{
				Enviosum=0;
			}else 
			{
				Enviosum=Integer.parseInt(Envio);
			}
			TotalStr=TotalStr.replace("$", "");
			TotalStr=TotalStr.replace(".", "");
			int Total=Integer.parseInt(TotalStr);
			int total1=(Cant*Prec)+Enviosum;
			//int total1=(3*32122)+Enviosum;
			if(Total == total1) 
			{
				System.out.println("precio OK");
			}
		}
		//driver.close();
	}

	/*static void Select_Prod()
	{
		try {
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
	    }
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
	}*/
	
}



