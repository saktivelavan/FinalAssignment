package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPg {
	
	@FindBy (linkText = "Login")
	WebElement loginLink;
	
	@FindBy(name = "email")
	WebElement userId;
	
	@FindBy(name = "password")
	WebElement pwd;
	
	@FindBy(xpath = "(//button[@class='btn btn-lg btn-primary pull-xs-right'])")
	WebElement logonBtn;

	public UserLoginPg(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public void loginToBlog(String strEmail, String strPwd) {
		loginLink.click();
		userId.sendKeys(strEmail);
		pwd.sendKeys(strPwd);
		logonBtn.click();
	}
}
