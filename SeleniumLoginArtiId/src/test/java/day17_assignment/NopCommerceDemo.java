package day17_assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/* 1)Open browser
 * 2)OPen Url https:
 * 3)provide email
 * 4)provide password
 * 5)click on login
 * 6)capture title of the dashboard page
 * 7)verify title of the page
 * 8)close browser
 */

public class NopCommerceDemo {

	public static void main(String[] args) {
		// 1)open browser
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// 2) open url
		driver.get("https://admin-demo.nopcommerce.com/login");

		// 3)provide user name

		// <input class="email valid" value="admin@yourstore.com" autofocus="autofocus"
		// type="email" data-val="true" data-val-email="Wrong email"
		// data-val-required="Please enter your email" id="Email" name="Email"
		// aria-describedby="Email-error" aria-invalid="false">

		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");

		// 4)provide password

		// <input value="admin" class="password valid" type="password" id="Password"
		// name="Password" aria-invalid="false">
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("admin");

		// 5)click on login
		// <button type="submit" class="button-1 login-button">Log in</button>
		// /html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button

		boolean check=driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).isEnabled();
		System.out.println(check);
		driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div/div[2]/div[1]/div/form/div[3]/button")).click();


		//6) validate login
		//<title>Your store. Login</title>
		String expected_title="Dashboard / nopCommerce administration";
				String actual_title=driver.getTitle();
				if(expected_title.equals(actual_title))
				{
					System.out.println("Login success test passed");
				}
				else
				{
					System.out.println("Login unsucess Test failed");
				}

	}

}
