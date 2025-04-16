package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class TestBase {

	private static TestBase testBase;
	private static WebDriver driver;
	
	private TestBase() {
		
		String strBrowserr = "chrome";
		
		if(strBrowserr.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		} else if(strBrowserr.equalsIgnoreCase("edge")) {
			 driver = new EdgeDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
	}
	
	public static void initDriver() {
		if(testBase == null) {
			testBase = new TestBase();
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
		
	public static void openURL(String strURL) {
			driver.get(strURL);
		}

	public static void tearDown() {
		if (driver!=null) {
		driver.close();
		driver.quit();
		} 
		testBase = null;
	}
		
	}
	
	

