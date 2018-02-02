package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {
	
	@FindBy(id="username")
	private WebElement UNTB;
	
	@FindBy(name="pwd")
	private WebElement PWTB;
	
	@FindBy(xpath="//div[.='Login ']")
	private WebElement LBTN;
	
	@FindBy(xpath="//span[.='invalid']")
	private WebElement ErMsg;
	
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void setUsername(String un) {
		UNTB.sendKeys(un);
	}
	public void setPassword(String pw) {
		PWTB.sendKeys(pw);
	}
	public void Clicklogin() {
		LBTN.click();
	}
	public void VerifyErrMsg(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,10);
		try {
			wait.until(ExpectedConditions.visibilityOf(ErMsg));
			Reporter.log("PASS:err msg got displayed");
		}catch(Exception e) {
			Reporter.log("FAIL:err msg NOT displayed");
			Assert.fail();
	    }
	}

}
