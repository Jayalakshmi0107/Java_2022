package day18;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LocatorDemo1 {

	public static void main(String[] args) {

//1)Launch browser
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver();
	
	//2)OPen url
	driver.get("http://automationpractice.com/index.php");
	driver.manage().window().maximize();
	//3)search box
	//<input class="search_query form-control ac_input" type="text" id="search_query_top" name="search_query" placeholder="Search" value="" autocomplete="off">
	driver.findElement(By.id("search_query_top")).sendKeys("T-shirts");
	//4)search button
	/*<button type="submit" name="submit_search" class="btn btn-default button-search">
	<span>Search</span>
</button>*/
	driver.findElement(By.name("submit_search")).click();
	
	/*<a class="product-name" href="http://automationpractice.com/index.php?id_product=7&amp;controller=product" title="">
    Printed Chiffon Dress
</a>*/
	//driver.findElement(By.linkText("Printed Chiffon Dress")).click();
	driver.findElement(By.partialLinkText("Printed Chiffon")).click();
	

	}

}
