package Utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class actionMethods {
	
	public WebDriver driver;

	public actionMethods(WebDriver driver){
		this.driver=driver;
	}
	
	public void scroll(WebElement element) {
	    ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}
}
