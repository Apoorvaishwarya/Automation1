package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

public class EnterTimeTrackpage {
	
	@FindBy(className="userProfileLink username")
	private WebElement Rbrtlnk;
	
	@FindBy(xpath="//span[.='Contact Information']")
	private WebElement CnInf;
	
	@FindBy(id="closeUserProfilePopupButton")
	private WebElement ClsBtn;
	
	@FindBy(xpath="//a[.='Logout']")
	private WebElement Lgt;
	
	public EnterTimeTrackpage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void verifyTitle(WebDriver driver,String eTitle) {
		WebDriverWait wait=new WebDriverWait(driver,10);
				try {
					wait.until(ExpectedConditions.titleIs(eTitle));
					Reporter.log("PASS:page displayed");
				}catch(Exception e) {
					Reporter.log("FAIL:page NOT displayed");
				}
	}
	public void clickRbrt() {
		Rbrtlnk.click();
	}

	public void verifyElmnt(String eElmnt) {
		String aElmnt=CnInf.getText();
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(aElmnt, eElmnt);
	}
	
	public void clsPopup() {
		ClsBtn.click();
	}
	public void clkLgt() {
		Lgt.click();
	}

}
