package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements IAutoConst {
	
	public WebDriver driver;
	
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	
	@Parameters({"browser"})
	@BeforeMethod(alwaysRun=true)
	
	public void openApp(String browser) {
		
		if(browser.equals("chrome")) {
			driver=new ChromeDriver();
		}else {
			driver=new FirefoxDriver();
		}
		
		String url = AL.getProperty(SETTINGS_PATH, "URL");
		driver.get(url);
		String time1=AL.getProperty(SETTINGS_PATH, "ITO");
		Long time=new Long(time1);
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	@AfterMethod(alwaysRun=true)
	
	public void closeApp(ITestResult res) {
		
		String name=res.getName();
		int status=res.getStatus();
		
		if(status==2) {
		  String imgPath=AL.getPhoto(driver, PHOTO_PATH, name);
		  Reporter.log("ImagePath"+imgPath,true);
		}
		
		driver.quit();
	}

}
