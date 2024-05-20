package hooks;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;



public class Base  {
	
	WebDriver driver;
	@Test
	public void launch()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.get("https://rahulshettyacademy.com/client/");
		
		driver.findElement(By.id("userEmail")).sendKeys("amrita.jha88@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Inno@1423");
		driver.findElement(By.xpath("//*[@id='login']")).click();
	List<WebElement> products=driver.findElements(By.cssSelector(".mb-3"));
	for(WebElement ele: products)
	{
		/*
		 * String name=ele.findElement(By.xpath("//div/div/h5/b")).getText();
		 * System.out.println(name); if(name.contains("ZARA COAT 3")) {
		 * ele.findElement(By.xpath("//button[2]")).click();
		 */
		
	String name=ele.findElement(By.cssSelector("b")).getText();
	System.out.println(name);
	if(name.equalsIgnoreCase("IPHONE 13 PRO"))
	{
		ele.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
	}
		}
	WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
	driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
	}
	
	
	@AfterClass
	public void closet()
	{
		//driver.close();
	}
}
