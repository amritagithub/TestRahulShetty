package hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.LandingPage;
import pageobjects.OrderConfirmationPage;
import pageobjects.ProductCataloguePage;

public class Base {

	WebDriver driver;

	@Test
	public void launch() {
		String productName = "IPHONE 13 PRO";
		String confirmationMessage="THANKYOU FOR THE ORDER.";

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
		CheckoutPage cp=new CheckoutPage(driver);
		cp.selectCountry("India");
		cp.waitForloading();
		cp.clickOnCheckOutButton();
		OrderConfirmationPage oc=new OrderConfirmationPage(driver);
		oc.getConfirmation(confirmationMessage);


	}

	@AfterClass
	public void closet() {
		// driver.close();
	}
}
