package day25;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.manage().window().maximize();
		
		System.out.println("Id of browser window "+ driver.getWindowHandle());
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windowids=driver.getWindowHandles(); // getWindowHandles returns only set also no duplicates
		
		//approach 1 convert set into list
		List<String> windowidlist=new ArrayList(windowids);
		String parentWindowId=windowidlist.get(0);
		String childWindowId=windowidlist.get(1);
		
driver.switchTo().window(childWindowId);//switch to child window
driver.findElement(By.xpath("//a[normalize-space()='Contact Sales']")).click();
System.out.println("Child browser window title "+driver.getTitle());



driver.switchTo().window(parentWindowId);//switch to child window
System.out.println("Parent browser window title "+driver.getTitle());


for(String windowid:windowids)
{
	String title=driver.switchTo().window(windowid).getTitle();
	if(title.equals("OrangeHRM"))
	{
		driver.close();
	}
}
	}
	
	
	
} 


