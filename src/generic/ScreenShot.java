package generic;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot implements Auto_const {
	public void capture(WebDriver driver) {
		String date=new Date().toString().replace(":","_");
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(photo_path+date+".png");
		try {
			FileHandler.copy(src,dest);

		}
		catch (IOException e) {
			System.out.println("failed to take screenshot");
		}
	}
}
