package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Generic_Test implements Auto_const {
	 public WebDriver driver;
	@BeforeMethod
	public void openApplication() {
		System.setProperty(chrome_key, chrome_value);
		driver= new ChromeDriver();
		driver.get("http://localhost/login.do");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	@AfterMethod
	public void closeApplication() {
		driver.quit();
	}
}
