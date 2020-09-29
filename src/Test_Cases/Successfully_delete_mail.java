package Test_Cases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.Config;
import page_helper.locators_values;

public class Successfully_delete_mail {
	public class Sign_in_test extends Config {
		locators_values loc=new locators_values();

		@Test
		public void Sucessfully_delete_mail_Test() throws InterruptedException {
			System.out.println("Sucessfully delete mail Test Start");

			clickByXpath(loc.signInLinkLoc)	;
			typeByXpath(loc.emailLoc, loc.emailValue);      
			time();
			clickByCss(loc.nextButtonBeforePass);
			typeByXpath(loc.passwordLoc,loc.passValue);
			clickByXpath(loc.nextButton);
			clickByXpath(loc.maillinkloc);
			time();
			clickByXpath(loc.sent_buttonloc);
			right_click_menu_selector();

		}

	} 
}
