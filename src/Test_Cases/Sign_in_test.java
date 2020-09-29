package Test_Cases;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Config;
import page_helper.locators_values;

public class Sign_in_test extends Config {
	locators_values loc=new locators_values();
	@Test
	public void loginWithValidCredentialUsingEmailTest(){
		System.out.println ("login With Valid Credential Using Email Test start");

		clickByXpath(loc.signInLinkLoc)	;

		typeByXpath(loc.emailLoc, loc.emailValue);

		clickByCss(loc.nextButtonBeforePass);

		typeByXpath(loc.passwordLoc,loc.passValue);

		clickByXpath(loc.nextButton);

		clickByXpath(loc.Nothanksloc);

		String act = driver.findElement(By.xpath(loc.myActualNameLoc)).getText(); 
		// act is coming from Domain -- the one developer build and release
		String exp = "keya"; // exp is coming from Requirement or Mock-up
		Assert.assertEquals(act, exp);






	}
}