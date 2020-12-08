package RegressionScripts;

import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import generic.Excel;
import generic.Generic_Test;

import pom.Enter_Time_Track_Page;
import pom.Login_Page;
import pom.ReportBugPage;

public class Regression extends Generic_Test {
	@Test
	public void validLoginLogout()
	{
		String username=Excel.readData("regression", 1, 0);
		String password=Excel.readData("regression", 1, 1);
		String hp_title=Excel.readData("regression", 1, 3);
		Login_Page lp=new Login_Page(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		Enter_Time_Track_Page ep=new Enter_Time_Track_Page(driver);
		ep.verifyTitle(hp_title, 5);
		ep.clickLogout();
		
	}
	
	@Test
	public void inavalidLogin()
	{
		String username=Excel.readData("regression", 2, 0);
		String password=Excel.readData("regression", 2, 1);
		String lp_title=Excel.readData("regression", 2, 2);
		Login_Page lp=new Login_Page(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		lp.verifyErrorMessage();
		lp.verifyTitle(lp_title, 5);
	}
	
	@Test
	public void verifyActitimeVersion()
	{
		String username=Excel.readData("regression", 3, 0);
		String password=Excel.readData("regression", 3, 1);
		String eversion=Excel.readData("regression", 3, 4);
		Login_Page lp=new Login_Page(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		Enter_Time_Track_Page ep=new Enter_Time_Track_Page(driver);
		ep.clickHelp();
		ep.clickAboutActitime();
		String aversion=ep.getActitimeVersion();
		Assert.assertEquals(aversion, eversion);
		ep.clickClose();
		ep.clickLogout();
	
	}
	
	@Test
	public void sendBugReport()
	{
		String username=Excel.readData("regression", 4, 0);
		String password=Excel.readData("regression", 4, 1);
		String bugsummary=Excel.readData("regression", 4, 5);
		String fn=Excel.readData("regression", 4, 6);
		String ln=Excel.readData("regression", 4, 7);
		String email=Excel.readData("regression", 4, 8);
		String commpany=Excel.readData("regression", 4, 9);
		Login_Page lp=new Login_Page(driver);
		lp.setUsername(username);
		lp.setPassword(password);
		lp.clickLogin();
		Enter_Time_Track_Page ep=new Enter_Time_Track_Page(driver);
		ep.clickHelp();
		ep.clickReportBug();
		ep.verifyTab(2, 5);
		Set<String> all_window = driver.getWindowHandles();
		for (String win : all_window) {
			driver.switchTo().window(win);
			
		}
		ReportBugPage rbp=new ReportBugPage(driver);
		rbp.enterBugDescription(bugsummary);
		rbp.enterFirstName(fn);
		rbp.enterLastName(ln);
		rbp.enterCompany(commpany);
		rbp.enterEmail(email);
		rbp.clicksend();
	}
}
