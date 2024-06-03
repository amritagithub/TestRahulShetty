package hooks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Hooks extends SubmitOrder{

	WebDriver driver;
	@BeforeTest
	public void launch()
	{
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\hp\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		 driver.get("https://rahulshettyacademy.com/angularpractice/shop");
		List<WebElement> ele=driver.findElements(By.xpath("//button[contains(text(),\"Add\")]"));
		for(WebElement ele1: ele)
		{JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].style.border='5px dotted yellow'", ele1);
		
			ele1.click();
		}
		driver.findElement(By.xpath("//*[@class='nav-link btn btn-primary']")).click();
	}

	@AfterTest
	public void closet()
	{
		//driver.close();
	}
}
