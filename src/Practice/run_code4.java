package Practice;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class run_code4 {
	static WebDriver driver;
	public static void main(String[] args) {
		run_code4 rn =new run_code4();
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		rn.wait_for_seconds(10, "Seconds");
		rn.user_clicks_on(rn.ImageButton);
		rn.wait_for_seconds(10, "Seconds");
		driver.quit();
		System.out.println("Driver quit");
	}
	
	public static String ImageButton 		= "//*[contains(text(),'Images')]";
	
	public  void user_clicks_on(String element)  {
       
		try{

			WebElement ele = driver.findElement(run_code4.getby(element));

			ele.click();
            System.out.println("Element fount and clicked on "+element+"at "+getSysTime());

		}

		catch(Exception e) {
			System.out.println("Element couldn't found and unable to click on element "+element+ "at "+getSysTime());
		
		}
	
	
	}
	
	public static By getby(String locator) {
		
		By locatorObj = null;
		
		String locatorType ="";
		
		switch (locatorType) {
		
		case "id":
			locatorObj = By.id(locator.replaceFirst(locatorType + ":", ""));
			break;
			
		case "name":
			locatorObj = By.name(locator.replaceFirst(locatorType + ":", ""));
			break;	

		case "css":
			locatorObj = By.cssSelector(locator.replaceFirst(locatorType + ":", ""));
			break;


		case "className":
			locatorObj = By.className(locator.replaceFirst(locatorType + ":", ""));
			break;

		case "xpath": 
          	locatorObj = By.xpath(locator.replaceFirst(locatorType + ":", ""));
			break;	


		default:
		locatorObj = By.xpath(locator);
			break;
	}

	return locatorObj;

	}
 public static void wait_for_seconds(int time,String Seconds) {
	 try {
		 int wait = 1000;
		 wait*=time;
		Thread.sleep(wait);
		System.out.println("Waiting for "+time+" "+Seconds);
	} 
	 catch (InterruptedException e) {
	
		e.printStackTrace();
	}
	 
	 
 }
 public Date getSysTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
		Date date = new Date();  
		//System.out.println(formatter.format(date)); 
		//System.out.println (" my test suite started at this time --> " +formatter.format(date));
		return date;
	}
}
