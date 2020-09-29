package Practice;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class run_codes {

public static void main(String[] args) throws Throwable {
		
		File inFile = new File("./mail.txt");
	    StringBuilder targetString = new StringBuilder("");
	    try {
	        FileReader fr = new FileReader(inFile);
	        BufferedReader br = new BufferedReader(fr);

	        String s = null;
	        while ((s = br.readLine()) != null) {
	            targetString.append(s);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		
		
		//driver=callDriver.LaunchChromeDriver("chrome");
		driver.manage().window().maximize();
		driver.get("https://www.yahoo.com");
	    System.out.println("Yahoo webpage displayed");
	    //System.out.println(ReadText());
	 
	   
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
	    driver.findElement(By.xpath("//*[@id=\"app\"]/div[2]/div/div[1]/nav/div/div[1]/a")).click();
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//*[@id=\"editor-container\"]/div[1]")).sendKeys(targetString);
}
}

