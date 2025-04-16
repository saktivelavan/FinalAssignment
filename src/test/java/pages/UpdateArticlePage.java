package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateArticlePage {

	@FindBy (xpath = "(//input[@name='title'])")
	WebElement articleTitle;
	
	@FindBy (xpath = "(//input[@name='description'])")
	WebElement description;
	
	@FindBy (xpath = "(//textarea[@name='body'])")
	WebElement articleBody;
	
	@FindBy (xpath = "(//input[@name='tags'])")
	WebElement tags;
	
	@FindBy (xpath = "(//fieldset/button)")
	WebElement updateBtn;
		
	@FindBy (linkText = "Edit Article")
	WebElement editArticle;
	
	@FindBy (linkText = "Delete Article")
	WebElement deleteArticle;
	
	@FindBy (xpath = "(//div[@class='article-preview'])")
	WebElement yourFeedPreview;
	

	public UpdateArticlePage(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public void goToEditArticlePage() {
		editArticle.click();
		
		}

	public void editArticle() {
		articleTitle.sendKeys("Article Title Updated"+System.currentTimeMillis());
	    updateBtn.click();
		}

	public void deleteArticle() {
		deleteArticle.click();
	}
	
	public boolean isArticleUpdated() {
		
		if (editArticle.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
	
public boolean isArticleDeleted() {
		
		if (yourFeedPreview.getText()=="Articles not available.") {
			return true;
		} else {
			return false;
		}
	}
}
