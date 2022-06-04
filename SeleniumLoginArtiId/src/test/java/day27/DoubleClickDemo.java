package day27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DoubleClickDemo {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();
		
		driver.switchTo().frame("iframeResult");//Switch to frame
		WebElement field1=driver.findElement(By.xpath("//input[@id='field1']"));
		field1.clear();
		field1.sendKeys("Welcome Home");

		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		Actions act=new Actions(driver);
		act.doubleClick(button).perform();//double click action

		WebElement field2=driver.findElement(By.xpath("//input[@id='field2']"));
		String copiedtext=field2.getAttribute("value");
		if(copiedtext.equals("Welcome Home"))
		{
			System.out.println("Text copied  double click  worked perfectly");
		}
		else
		{
			System.out.println("Text not copied  Double click didnt work");
		}

	}

}
