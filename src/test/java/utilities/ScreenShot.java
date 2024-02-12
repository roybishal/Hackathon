package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public void takeSS(WebDriver driver, String name) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
		File file = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File targetLocation = new File(System.getProperty("user.dir") + "\\screenshots\\"+name+".png");
		FileUtils.copyFile(file, targetLocation);
	}

}
