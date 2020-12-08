package generic;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Page {
	
	WebDriver driver;
	public Base_Page(WebDriver driver) { 
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}
	public void verifyTitle(String title, int time) { 
		WebDriverWait wait=new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.titleContains(title));
			System.out.println("valid test");
		} catch (Exception e) {
			System.out.println("invalid title");
		}
		
	}
	public void verifyElement(WebElement element,int time) {
		WebDriverWait wait=new WebDriverWait(driver, time);
		try {
			wait.until(ExpectedConditions.visibilityOf(element));
			System.out.println("element visible");
		} catch (Exception e) {
			System.out.println("element not visible");
			// TODO: handle exception
		}
	}
	public void verifyTab(int noOfWindow,int time) {
	WebDriverWait wait=new WebDriverWait(driver,time);
	try {
		wait.until(ExpectedConditions.numberOfWindowsToBe(noOfWindow));
		System.out.println("child tab  presernt");
	} catch (Exception e) {
		System.out.println("child tab not presernt");
	}
	}
	public void mouseHover(WebElement element) {
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	public void rightClick(WebElement element) {
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	public void selectByName(WebElement element, String value) {
		Select s=new Select(element);
		s.selectByVisibleText(value);
	}
	public List<String> getAllOptionsDropdown(WebElement element) {
	List<String> l1 = new ArrayList<String>();
	Select s=new Select(element);
	List<WebElement> options=s.getOptions();
	for (WebElement opt: options) {
		l1.add(opt.getText());
		
	}
	return l1;
		
	}
	public void scrollToSpecificLocation(WebElement element) {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView()", element);
		
	}
}