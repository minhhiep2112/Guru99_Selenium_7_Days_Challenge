package initDriver;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import findProperty.FindProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.LoginPageActions;

public class InitialDriver {
	
	protected WebDriver driver;
	protected LoginPageActions login;
	
	@BeforeMethod
	public void StartBrowser() throws IOException {
				
		// start browser
		if(FindProperties.locateProperty("browser").equalsIgnoreCase("firefox")) {
					
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		}
		else if (FindProperties.locateProperty("browser").equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		// set full screen and implicitly wait
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		// go to URL
		driver.navigate().to(FindProperties.locateProperty("base_URL"));
		
		// declare actions for login page
		login = new LoginPageActions(driver);
		
	}
	
	
	@AfterMethod
	public void CloseBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
}
