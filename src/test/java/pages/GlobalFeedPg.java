package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlobalFeedPg {

	@FindBy (linkText = "Home")
	WebElement homePgLink;
	
	@FindBy (linkText = "Global Feed")
	WebElement glbFeedLink;
	
	@FindBy (xpath = "(//h1[contains(text(),'Sakti Article')])[1]")
	WebElement artTitle;
	

	public GlobalFeedPg(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	
	public void goToGlobalFeedPage() {
		homePgLink.click();
		glbFeedLink.click();
		}

	public void goToArticle() {
		artTitle.click();
		}

	public String isArticleViewable() {
        return artTitle.getText();
        			}

	
}
