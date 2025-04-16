package stepDefs;


import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

import base.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.UserLoginPg;



public class UserLoginStepDef {
	WebDriver driver =TestBase.getDriver();
	UserLoginPg userLoginPg;
	
	public UserLoginStepDef() {
		userLoginPg = new UserLoginPg(driver);
	}

	@Given("User is on Login page")
	public void user_is_on_login_page() {
	   TestBase.openURL("https://conduit-realworld-example-app.fly.dev/");
	}
	@When("User enters credentials")
	public void user_enters_and(DataTable userData) {
		List<Map<String, String>> data = userData.asMaps();
		String strUser =data.get(0).get("username");
		String strPwd =data.get(0).get("password");
		
	   userLoginPg.loginToBlog(strUser, strPwd);
	  
    }
	
	@Then("User should be on Home Page")
	public void user_should_be_on_home_page() {
	   Assert.assertTrue(userLoginPg.isLoginSuccess());
	}
	
}
