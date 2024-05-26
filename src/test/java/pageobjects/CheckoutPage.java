package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.AbstractComponents;

public class CheckoutPage  extends AbstractComponents{

	WebDriver driver;
	public CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="[placeholder='Select Country']")
	WebElement selectCountry;
	@FindBy(css=".ta-item:nth-of-type(2)")
	WebElement selectPaymentMethod;
	@FindBy(css=".action__submit")
	WebElement submit;
	
	
	By results=By.cssSelector(".ta-results");
	
	public void selectCountry(String country)
	{
		perFormActionSendKeys(selectCountry, country);
		
	}
	
	public void waitForloading()
	{
		waitForElementToAppear(results);
	}
	
	public void clickOnCheckOutButton()
	{
		selectPaymentMethod.click();
		submit.click();
		
	}
}
