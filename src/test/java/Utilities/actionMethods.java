package Utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.google.common.io.Files;

public class actionMethods {
	
	public WebDriver driver;

	public actionMethods(WebDriver driver){
		this.driver=driver;
	}
	
	public void scroll(WebElement element) {
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void screenshotTaker() throws IOException {
		File file=((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destFile=new File("C:\\Users\\ARITRA DEY\\eclipse-workspace\\automationAmazon\\test-output");
		Files.copy(file,destFile);
	}
	
	 public void moveSlider(WebElement slider, int xOffset) throws InterruptedException {
	        // Scroll the slider into view safely
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", slider);
	        Thread.sleep(500); // Allow scroll to finish

	        Actions actions = new Actions(driver);
	        actions.moveToElement(slider)
	               .clickAndHold()
	               .moveByOffset(xOffset, 0)
	               .release()
	               .perform();
	    }
}
