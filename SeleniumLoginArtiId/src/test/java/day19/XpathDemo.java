package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathDemo {

	public static void main(String[] args) {
		//Launch chrome browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		//open a url
		driver.get("http://automationpractice.com/index.php");
		driver.manage().window().maximize();
		
		//absolute  xpath
		driver.findElement(By.xpath("/html/body/div/div[1]/header/div[3]/div/div/div[2]/form/input[4]")).sendKeys("T-Shirts");
		
		
		//relative xpaath
		driver.findElement(By.xpath("//button[@name='submit_search']")).click();

	}

}
