package testcase;

import static org.testng.Assert.assertNotEquals;
import java.io.IOException;
import org.testng.annotations.Test;
import data_driven.GetData;
import initDriver.InitialDriver;

public class TC001_LogIn extends InitialDriver {
	
	@Test(dataProvider = "example_data", dataProviderClass = GetData.class)
	public void SuccessfullLogin(String name, String pass) throws IOException {
		
		// enter user name and password, click login, then verify login successful
		login.enterUserName(name);
		login.enterPassword(pass);
		login.clickLoginButton();
	//	assertTrue(driver.findElement(By.xpath(FindProperties.locateProperty("welcome_message_xpath"))).getText().contains("mngr506560"),
	//			"Wrong user name or password!");
		assertNotEquals(driver.getTitle(), "Guru99 Bank Home Page", "Wrong username or password!");
		
	}
	
}
