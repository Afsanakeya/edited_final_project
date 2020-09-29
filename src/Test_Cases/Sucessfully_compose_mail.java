package Test_Cases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Config;
import base.WDFunctions;
import page_helper.locators_values;

public class Sucessfully_compose_mail {
	public class Sign_in_test extends Config {
		locators_values loc=new locators_values();

		@Test
		public void Sucessfully_compose_mail_Test() throws InterruptedException {
			System.out.println("Sucessfully compose mail Test Start");

			clickByXpath(loc.signInLinkLoc)	;
			typeByXpath(loc.emailLoc, loc.emailValue);
			clickByCss(loc.nextButtonBeforePass);
			typeByXpath(loc.passwordLoc,loc.passValue);
			clickByXpath(loc.nextButton);
            clickByXpath(loc.maillinkloc);
			clickByXpath(loc.Composelink);
			time();
            typeByXpath(loc.To_link,loc.writeTolink);
			time();
			typeByXpath(loc.Subject_link,loc.writesublink);
			time();
			WDFunctions.sendKeyForDataFromDataFile(loc.Email_compose_field,WDFunctions.st);
			String act = driver.findElement(By.xpath(loc.page_title_loc)).getText(); 
			// act is coming from Domain -- the one developer build and release
			String exp = "yahoo!mail";
			// exp is coming from Requirement or Mock-up
			Assert.assertEquals(act, exp);
		}
	}
}
