package testcase;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import findProperty.FindProperties;
import initDriver.InitialDriver;

public class TC001_LogIn extends InitialDriver {
	
	@Test
	public void SuccessfullLogin() throws IOException {
		
		// enter user name and password, click login, then verify login successful
		login.enterUserName("mngr506560");
		login.enterPassword("gytEdAd");
		login.clickLoginButton();
		assertTrue(driver.findElement(By.xpath(FindProperties.locateProperty("welcome_message_xpath"))).getText().contains("mngr506560"));
		assertEquals(driver.getTitle(), "Guru99 Bank Manager HomePage");
		
	}
	
}
