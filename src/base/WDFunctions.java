package base;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import Practice.run_code4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WDFunctions {

	public static WebDriver driver;

	public void getCurrentTime() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
		Date date = new Date();  
		System.out.println(formatter.format(date)); 
		System.out.println ("My test suite started at --> " +formatter.format(date));
	}

	// --------------------- EDIT BOX / TYPE -----------------------
	public void typeByXpath(String loc, String val){
		try {
			driver.findElement(By.xpath(loc)).clear();
			driver.findElement(By.xpath(loc)).sendKeys(val);
			System.out.println("Element found and insert values" + loc);
		}
		catch (Exception e) {
			System.out.println("Unable to insert values" +e);
		}
	}
	public void typeById(String loc, String val){
		driver.findElement(By.id(loc)).sendKeys(val);
	}
	public void typeByCss(String loc, String val){
		driver.findElement(By.cssSelector(loc)).clear();
		driver.findElement(By.cssSelector(loc)).sendKeys(val);
	}
	public void typeByName(String loc, String val){
		driver.findElement(By.name(loc)).sendKeys(val);
	}
	// ------------------- CLICK -----------------
	public void clickByXpath (String loc){
		try {
			driver.findElement(By.xpath(loc)).click();
			System.out.println("Element found and clicked on" + loc + "at "+getSysTime());
		}
		catch (Exception e) {
			System.out.println("Unable to Click on" +e+"\n"+"System time "+getSysTime());
		}

	}
	public void clickByCss (String loc){
		try {
			driver.findElement(By.cssSelector(loc)).click();
			driver.findElement(By.xpath(loc)).click();
			System.out.println("Element found and clicked on" + loc + "at "+getSysTime());
		}
		catch (Exception e) {
			System.out.println("Unable to Click on" +e+"\n"+"System time "+getSysTime());
		}

	}

	public void clickById (String loc){
		driver.findElement(By.id(loc)).click();
	}

	public void clickByName (String loc){
		driver.findElement(By.name(loc)).click();
	}

	public void clickByLinkText (String loc){  
		driver.findElement(By.linkText(loc)).click();
	}

	public void time() throws InterruptedException {
	Thread.sleep(2000);
	}
	public static final String FilePath  = "./mail.txt";
	public static final StringBuilder st = readfile(FilePath);
	public static StringBuilder readfile(String filePath) {
		File inFile = new File(filePath);
		StringBuilder DatafromDataSheet = new StringBuilder("");
		try {
			FileReader fr = new FileReader(inFile);
			BufferedReader br = new BufferedReader(fr);

			String s = null;
			while ((s = br.readLine()) != null) {
				DatafromDataSheet.append(s);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return DatafromDataSheet;
	}
	public static void sendKeyForDataFromDataFile(String xpath, StringBuilder targetString) {

		try {
			driver.findElement(By.xpath(xpath)).sendKeys(targetString);

			System.out.println("Data composed successfully in text edit/text compose field"+"\n");

		}

		catch (Exception e) {

			System.out.println("Unable to write data in compose/text edit field" + e);
		}
	}

	public void right_click_menu_selector() {
		Actions actions = new Actions(driver);
		WebElement btnElement = driver.findElement(By.xpath("//*[@id=\"mail-app-component\"]/div/div/div[2]/div/div/div[3]/div/div[1]/ul/li[3]/a/div/div[2]"));
		actions.contextClick(btnElement).perform();
		System.out.println("Right click Context Menu displayed");
		WebElement elementOpen = driver.findElement(By.xpath("//*[@id=\"app\"]/div[7]/div/div[1]/div/div/ul/li[3]/a"));  
		elementOpen.click(); 
		driver.findElement(By.xpath("//*[@id=\"ybar-inner-wrap\"]/div[2]/div/div[3]/div[1]/div/label")).click();
		try {
			driver.findElement(By.xpath("//*[@id=\"ybarAccountMenuBody\"]/a[3]/span[2]")).click();
			System.out.println("Successfully deleted the mail");}
		catch(Exception e) {
			System.out.println("Unable to delete mail"+e);
		}

	}
	public void assertEqualByXpath (String loc, String expValue){
		String act = driver.findElement(By.xpath(loc)).getText(); 
		// act is coming from Domain -- the one developer build and release
		String exp = expValue; // exp is coming from Requirement or Mock-up
		Assert.assertEquals(act, exp);
	}
	
	public Date getSysTime3() {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");  
		Date date = new Date();  
		//System.out.println(formatter.format(date)); 
		//System.out.println (" my test suite started at this time --> " +formatter.format(date));
		return date;
	}
	
	
	
	public  void user_clicks_on(String element)  {
		
	    System.out.println("Looking for the element "+element+getSysTime()+"\n");   
		try{

			WebElement ele = driver.findElement(run_code4.getby(element));

			ele.click();
            System.out.println("Element fount and clicked on "+element+"at  "+getSysTime()+"\n");

		}

		catch(Exception e) {
			System.out.println("Element couldn't found and unable to click on element "+element+ "at  "+getSysTime()+"\n");
		
		}
	}
	
	public  void user_pass_the_value_on(String element,String valueToPass)  {
		
		System.out.println("Looking for the element "+element+getSysTime()+"\n"); 	       
		try{

			WebElement ele = driver.findElement(run_code4.getby(element));

			ele.sendKeys(valueToPass);;
            System.out.println("Element fount and paassed the value to "+element+"at  "+getSysTime()+"\n");

		}

		catch(Exception e) {
			System.out.println("Element couldn't found and unable to pass the value to "+element+ "at  "+getSysTime()+"\n");
		
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
 public Date getSysTime1() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");  
		Date date = new Date();  
		//System.out.println(formatter.format(date)); 
		//System.out.println (" my test suite started at this time --> " +formatter.format(date));
		return date;
	}
 public String getSysTime() {
	 DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		Calendar calander = Calendar.getInstance();
		String GetCurrentTime = dateFormat.format(calander.getTime());
		return GetCurrentTime;
	}
 
 /*
 public static void TakeScreenshots (WebDriver driver,String FileName) throws Throwable {
		
		TakesScreenshot tss = (TakesScreenshot) driver;
		File fl= tss.getScreenshotAs(OutputType.FILE); // to take screenshot 
		FileUtils.copyFile(fl,new File("./Screenshot/"+FileName+".jpg"));//to save the file 
		if (tss.getScreenshotAs(OutputType.FILE) != null) {
			System.out.println("ScreenShot Taken");
			
		}
		else {
			System.out.println("ScreenShot Couldn't Take");
		}		
     }
     */
 
}
