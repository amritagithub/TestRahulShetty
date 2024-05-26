package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.AbstractComponents;

public class ProductCataloguePage extends AbstractComponents {

	WebDriver driver;
	By productsBy = By.cssSelector(".mb-3");

	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".mb-3")
	List<WebElement> products;
	@FindBy(css = ".card-body button:last-of-type")
	WebElement proceedToCart;
	@FindBy(css = "[routerlink*='cart']")
	WebElement clickOnCart;
	By AddTOCart=By.cssSelector(".card-body button:last-of-type");
	By toastloader = By.cssSelector("#toast-container");

	public void loadingIconAppearWait() {
		waitForElementToAppear(toastloader);
	}

	public void loadingIconDissappearWait() {
		waitForElementToDissapear(toastloader);
	}

	public List<WebElement> getProductList() {
		waitForElementToAppear(productsBy);

		return products;

	}

	public  void findProductByName(String productname) {
		List<WebElement> productList = getProductList();
		for (WebElement el : productList) {
			if (el.findElement(By.cssSelector("b")).getText().equals(productname)) {
				System.out.println(el);
				el.findElement(AddTOCart).click();
				
			}

		}

	}
	public void clickOnCart()
	{clickOnCart.click();
		
	}
	
}
