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
import pages.CreateArticlePg;
import pages.GlobalFeedPg;
import pages.UpdateArticlePage;
import pages.UserLoginPg;



public class ArticleStepDef {
	WebDriver driver =TestBase.getDriver();
	UserLoginPg userLoginPg;
	CreateArticlePg createArticlePg;
	GlobalFeedPg globalFeedPg;
	UpdateArticlePage updateArticlePg;
	
	public ArticleStepDef() {
		userLoginPg = new UserLoginPg(driver);
		createArticlePg = new CreateArticlePg(driver);
		globalFeedPg = new GlobalFeedPg(driver);
		updateArticlePg = new UpdateArticlePage(driver);
	}

	// User Login
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

	//	Create Article
	@Given("User should be on New Article Page")
	public void user_should_be_on_new_article_page() {
	createArticlePg.goToNewArticle();    
	}
	
	@When("User enters Article details")
	public void user_enters_article_details(DataTable articleData) {
		List<Map<String, String>> data = articleData.asMaps();
		String title =data.get(0).get("title");
		String desc =data.get(0).get("Desc");
		String body =data.get(0).get("Content");
		String tag =data.get(0).get("tag");
		createArticlePg.enterDetails(title, desc, body, tag);
		createArticlePg.publishArticle();
	}
	
	@Then("Article must be created")
	public void article_must_be_created() {
//		String strgUrl = driver.getCurrentUrl();
//		Assert.assertTrue(strgUrl.contains("sakti"));
		Assert.assertTrue(createArticlePg.isArticleAdded());
	}
	
	//View Article
	@Given("User should be on Global Feed page")
	public void user_should_be_on_global_feed_page() {
	    globalFeedPg.goToGlobalFeedPage();
	}
	
	@When("User select an article {string}")
	public void user_select_an_article(String string) {
	    globalFeedPg.goToArticle();    
	}
	
	@Then("Article detail page must be displayed")
	public void article_detail_page_must_be_displayed() {
		String strUrl = driver.getCurrentUrl();
		Assert.assertTrue(strUrl.contains("article"));
	}
	
	
	//Update Article
	
	@When("User update article detail")
	public void user_update_article_detail() {
	
		updateArticlePg.goToEditArticlePage();
		
	}
	
	@Then("Article detail must be updated")
	public void article_detail_must_be_updated() {
		updateArticlePg.editArticle();
		Assert.assertTrue(updateArticlePg.isArticleUpdated());
	}
	
	//Delete an Article
	@When("User delete article")
	public void user_delete_article() {
	 
	}
	
	@Then("Article must be deleted")
	public void article_must_be_deleted() {
	
	}
	
}
