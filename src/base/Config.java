package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Config extends WDFunctions {

	@BeforeSuite
	public void startTestSuite() {
		getCurrentTime();
	}

	@Parameters("browser")
	@BeforeMethod
	public void beforeEachTestMethod(String browser) {
		if (browser.equalsIgnoreCase("ch")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			driver = new ChromeDriver();
			System.out.println(" chrome driver open ++++++++++++++++ ");
		} 
		/*else if (browser.equalsIgnoreCase("ff")) {
			System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver ");
			driver = new FirefoxDriver(); 
			System.out.println (" Firefox driver open ++++++++++++++++ ");
		}*/

		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(90, TimeUnit.SECONDS);

		// open browser	
		driver.get("https://www.yahoo.com/");
	}


	@AfterMethod
	public void afterEachTestMethod(){
		// close browser
		driver.close();
		System.out.println (" Test is ended and browser is closeded +++++++ ");
	}

	@AfterSuite
	public void tearDown(){
		driver.quit();
		System.out.println (" Terminated WD +++++++ ");
	}
}

