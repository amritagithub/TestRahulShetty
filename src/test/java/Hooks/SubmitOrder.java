package hooks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import pageobjects.CartPage;
import pageobjects.CheckoutPage;
import pageobjects.LandingPage;
import pageobjects.OrderConfirmationPage;
import pageobjects.ProductCataloguePage;

public class SubmitOrder extends BaseTest {

	WebDriver driver;

	@Test
	public void launch() {
		String productName = "IPHONE 13 PRO";
		String confirmationMessage="THANKYOU FOR THE ORDER.";

	LandingPage landingpage=launchApplication();
		// .get("https://rahulshettyacademy.com/client/");
	ProductCataloguePage pc=landingpage.loginApplication("amrita.jha88@gmail.com", "Inno@1423");
		
		pc.findProductByName(productName);
		pc.loadingIconAppearWait();
		pc.loadingIconDissappearWait();
		CartPage cartPage=pc.clickOnCart();
		cartPage.verifyListContainsProduct(productName);
		CheckoutPage cp=cartPage.clickOnChcekOut();
		
		cp.selectCountry("India");
		cp.waitForloading();
		OrderConfirmationPage oc=cp.clickOnCheckOutButton();
		
		oc.getConfirmation(confirmationMessage);


	}

	@AfterClass
	public void closet() {
		// driver.close();
	}
}
