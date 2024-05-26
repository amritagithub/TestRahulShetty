package hooks;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.LandingPage;
import pageobjects.ProductCataloguePage;

public class Base {

	WebDriver driver;

	@Test
	public void launch() {
		String productName = "IPHONE 13 PRO";

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hp\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		// .get("https://rahulshettyacademy.com/client/");
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();
		landingpage.loginApplication("amrita.jha88@gmail.com", "Inno@1423");
		ProductCataloguePage pc=new ProductCataloguePage(driver);
		pc.findProductByName(productName);
		pc.loadingIconAppearWait();
		pc.loadingIconDissappearWait();
		pc.clickOnCart();
		CartPage cartPage=new CartPage(driver);
		cartPage.verifyListContainsProduct(productName);
		cartPage.clickOnChcekOut();
		Actions action = new Actions(driver);
		action.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build()
				.perform();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.cssSelector(".ta-item:nth-of-type(2)")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String confirmMessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));


	}

	@AfterClass
	public void closet() {
		// driver.close();
	}
}
