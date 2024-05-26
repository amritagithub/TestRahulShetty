package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//*[@class='cartSection']/h3")
	List<WebElement> listOfItems;
	@FindBy(css=".totalRow button")
	WebElement checkOUtButton;
	
	
	
	public void verifyListContainsProduct(String productName)
	{
		for (WebElement el : listOfItems) {
			if (el.getText().equals(productName)) {
				Assert.assertEquals(el.getText(), productName);
				

			}

		}
	}
	public void clickOnChcekOut()
	{
		checkOUtButton.click();
	}
	

}
