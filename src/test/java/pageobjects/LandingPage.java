package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents
{
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public WebElement getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(WebElement userEmail) {
		this.userEmail = userEmail;
	}
	public WebElement getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(WebElement userPassword) {
		this.userPassword = userPassword;
	}
	public WebElement getLoginButton() {
		return loginButton;
	}
	public void setLoginButton(WebElement loginButton) {
		this.loginButton = loginButton;
	}
	
	//method to login to application
	public void loginApplication(String useremail, String userpassword)
	{
		userEmail.sendKeys(useremail);
		userPassword.sendKeys(userpassword);
		loginButton.click();
	}
	
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");
	}
	
	@FindBy(id="userEmail")
	private
	WebElement userEmail;
	@FindBy(id="userPassword")
	private
	WebElement userPassword;
	@FindBy(xpath="//*[@id='login']")
	private
	WebElement loginButton;
	
	//Opublic WebElement userEmail=driver.findElement(By.id("userEmail"));
	//public WebElement userPassword=driver.findElement(By.id("userPassword"));
	//public =driver.findElement(By.xpath("//*[@id='login']"));

}
