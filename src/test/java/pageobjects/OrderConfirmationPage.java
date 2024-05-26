package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.AbstractComponents;

public class OrderConfirmationPage extends AbstractComponents{
	
	WebDriver driver;
	public OrderConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmationMessage;
	
	public void getConfirmation(String Message)
	{
	String confirmMessage = confirmationMessage.getText();
	Assert.assertTrue(confirmMessage.equalsIgnoreCase(Message));

}}
