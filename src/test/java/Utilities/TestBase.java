package Utilities;




import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class TestBase {

	public static WebDriver driver;
	
	public static WebDriver DriverManager() throws IOException {
		if (driver == null) {
		String filepath="C:/Users/ARITRA DEY/eclipse-workspace/automationAmazon/Config/Configuration.properties";
		Properties p=new Properties();
		FileReader fr= new FileReader(filepath);
		p.load(fr);
		String browser = p.getProperty("browser");
	if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver","C:/Users/ARITRA DEY/eclipse-workspace/Chrome Driver/Chrome Driver 135/chromedriver.exe");
		driver= new ChromeDriver();

	}
	if(browser.equalsIgnoreCase("firefox")) {
		System.setProperty("webdriver.gecko.driver","C:/Users/ARITRA DEY/eclipse-workspace/FireFox Driver/geckodriver.exe");
		driver= new FirefoxDriver();
	}
	if(browser.equalsIgnoreCase("IE")) {
		System.setProperty("webdriver.InternetExploreDriver.driver","C:/Users/ARITRA DEY/eclipse-workspace/Internet Explorer Driver/IEDriverServer.exe");
		driver= new InternetExplorerDriver();
	}
	/*if(browser=="Safari") {
		System.setProperty("webdriver.chrome.driver","C:/Users/ARITRA DEY/eclipse-workspace/Chrome Driver/Chrome Driver/chromedriver.exe");
		driver= new SafariDriver();
	}*/
	
	}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	return driver;
	}
	
	public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null; // Prevent reusing a dead session
        }
	}
}
	
	

