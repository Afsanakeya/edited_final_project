package Test_Cases;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import Practice.run_codes;
import base.Config;
import base.WDFunctions;
import page_helper.locators_values;

public class Successfully_sent_mail_test {
	public class Sign_in_test extends Config {
		locators_values loc=new locators_values();
		
		WDFunctions wf= new WDFunctions();
		
		@Test
		public void Sucessfully_sent_mail_Test() throws InterruptedException {
			System.out.println("Sucessfully sent mail Test Start"+"\n");
			wait_for_seconds(3,"Seconds");
			
			wf.user_clicks_on(loc.signInLinkLoc);
			wait_for_seconds(3,"Seconds");
			
			wf.user_pass_the_value_on(loc.emailLoc, loc.emailValue);
			wait_for_seconds(3,"Seconds");
			
			wf.user_clicks_on(loc.nextButtonBeforePass);
			
			wf.user_pass_the_value_on(loc.passwordLoc,loc.passValue);
			
			wf.user_clicks_on(loc.nextButton);

			wf.user_clicks_on(loc.maillinkloc);
			wait_for_seconds(3,"Seconds");
			
			wf.user_clicks_on(loc.Composelink);
			wait_for_seconds(3,"Seconds");
			
			sendKeyForDataFromDataFile(loc.Email_compose_field,WDFunctions.st);
			
			wf.user_pass_the_value_on(loc.To_link,loc.writeTolink);
			
			wait_for_seconds(3,"Seconds");
			
			wf.user_pass_the_value_on(loc.Subject_link,loc.writesublink);
			wait_for_seconds(3,"Seconds");
			
			wf.user_clicks_on(loc.Send_button);
			
			String act = driver.findElement(By.xpath(loc.successfully_mail_sent)).getText(); 
			// act is coming from Domain -- the one developer build and release
			String exp = "Your message has been sent.";
			// exp is coming from Requirement or Mock-up
			Assert.assertEquals(act, exp);

		}
	}
}