package Practice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class run_code3 {
	static WebDriver driver;
	static String xpath  = "q";
	public static final String FilePath  = "./mail.txt";
	public static final StringBuilder st = readfile(FilePath);

	public static void main(String[] args) {



		System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
		driver = new ChromeDriver();
		//driver=callDriver.LaunchChromeDriver("chrome");

		driver.manage().window().maximize();
		driver.get("http://www.google.com");

		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("q")));
		try {
			sendKeyForDataFromDataFile(xpath,st);
			//driver.findElement(By.name("q")).sendKeys(targetString);
			System.out.println("email successfully composed");
			Thread.sleep(5000);
		}

		catch (Exception e) {
			System.out.println("Unable to compose email" + e);
		}

		// driver.findElement(By.name("q")).sendKeys(targetString);
		// driver.findElement(By.name("btnG")).click();
		driver.quit();
	}
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
			driver.findElement(By.name(xpath)).sendKeys(targetString);

			System.out.println("Data composed successfully in text edit/text compose field");

		}

		catch (Exception e) {

			System.out.println("Unable to write data in compose/text edit field" + e);
		}

	}
}
