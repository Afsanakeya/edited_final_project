package Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class run_code2 {
public static void main(String[] args) throws InterruptedException {
	 
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.yahoo.com");
	
	 driver.findElement(By.xpath("//*[@id=\"header-profile-menu\"]")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys("login_practice");
	    //driver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys("login_practice");
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[@id=\"login-passwd\"]")).sendKeys("Yahoo007");
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[@id=\"header-mail-button\"]/span")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[@id=\"mail-app-component\"]/div[1]/div/div[2]/div/div/div[3]/div/div[1]/ul/li[3]/a/div/div[1]/div[1]/button")).click();
	    Thread.sleep(4000);
	  
	  
	    //Instantiate Action Class
	    Actions actions = new Actions(driver);
	 
	    //Retrieve WebElement to perform right click
	    WebElement btnElement = driver.findElement(By.xpath("//*[@id=\"mail-app-component\"]/div[1]/div/div[2]/div/div/div[3]/div/div[1]/ul/li[3]/a/div/div[1]"));
	 
	    //Right Click the button to display Context Menu&nbsp;
	    actions.contextClick(btnElement).perform();
	    System.out.println("Right click Context Menu displayed");
	    Thread.sleep(4000);
	    //Following code is to select item from context menu which gets open up on right click, this differs 
	    //depending upon your application specific test case: 
	    //Select and click 'Copy me' i.e. 2nd option in Context menu 
	   WebElement elementOpen = driver.findElement(By.xpath("//*[@id=\"app\"]/div[7]/div/div[1]/div/div/ul/li[3]/a"));  
	    elementOpen.click(); 
	    Thread.sleep(4000);
	    
	    driver.findElement(By.xpath("//*[@id=\"ybar-inner-wrap\"]/div[2]/div/div[3]/div[1]/div/label")).click();
	    Thread.sleep(4000);
	    
	    driver.findElement(By.xpath("//*[@id=\"ybarAccountMenuBody\"]/a[3]/span[2]")).click();
	    Thread.sleep(4000);
	 
	    // Accept the Alert 
	   // driver.switchTo().alert().accept();
	   // System.out.println("Right click Alert Accepted");
	 
	    // Close the main window 
	    driver.close();
	    System.out.println("Driver closed");
}
		
	}