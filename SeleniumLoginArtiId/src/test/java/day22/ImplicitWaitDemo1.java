package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWaitDemo1
{
	public static void main(String[] args)  {
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	driver.get("https://www.google.com/"); //open url on the browser 
	driver.findElement(By.xpath("//input[@title='Search']")).sendKeys(Keys.RETURN);
	
	
	
	driver.findElement(By.xpath("//h3[text()='Selenium']")).click();
	}
}
