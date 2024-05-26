package hooks;




	import java.time.Duration;
	import java.util.List;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.annotations.AfterClass;
	import org.testng.annotations.Test;

	import pageobjects.LandingPage;
	import pageobjects.ProductCataloguePage;

	public class singleclass {

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
			List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
			for (WebElement ele : products) {
				/*
				 * String name=ele.findElement(By.xpath("//div/div/h5/b")).getText();
				 * System.out.println(name); if(name.contains("ZARA COAT 3")) {
				 * ele.findElement(By.xpath("//button[2]")).click();
				 */

				String name = ele.findElement(By.cssSelector("b")).getText();
				System.out.println(name);
				if (name.equalsIgnoreCase(productName)) {
					ele.findElement(By.cssSelector(".card-body button:last-of-type")).click();

				}
			}
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("#toast-container")));
			driver.findElement(By.cssSelector("[routerlink*='cart']")).click();
			List<WebElement> cartPage = driver.findElements(By.xpath("//*[@class='cartSection']/h3"));

			for (WebElement el : cartPage) {
				if (el.getText().equals(productName)) {
					Assert.assertEquals(el.getText(), productName);
					driver.findElement(By.cssSelector(".totalRow button")).click();

				}

			}
			Actions action = new Actions(driver);
			action.sendKeys(driver.findElement(By.cssSelector("[placeholder='Select Country']")), "India").build()
					.perform();
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
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


