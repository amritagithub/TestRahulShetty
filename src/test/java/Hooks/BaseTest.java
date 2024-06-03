package hooks;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pageobjects.LandingPage;

public class BaseTest {
	WebDriver driver;
	Properties prop;
	FileInputStream fis;
	public WebDriver intializeDriver() 
	{
		prop=new Properties();
		
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Properties//global.properties");
		
		
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String browser=prop.getProperty("browser");
		if(browser.equals("chrome"))
		{
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\hp\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
	
		
	}
		else
		{
			System.out.println("other browser");
		}


	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	return driver;
}
	public LandingPage launchApplication()
	{
		
		driver=intializeDriver();
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTo();
		return landingpage;
		
		}
	}