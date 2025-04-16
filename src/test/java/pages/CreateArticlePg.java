package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateArticlePg {

	@FindBy (linkText = "New Article")
	WebElement createArticleLink;
	
	@FindBy (xpath = "(//input[@name='title'])")
	WebElement articleTitle;
	
	@FindBy (xpath = "(//input[@name='description'])")
	WebElement description;
	
	@FindBy (xpath = "(//textarea[@name='body'])")
	WebElement articleBody;
	
	@FindBy (xpath = "(//input[@name='tags'])")
	WebElement tags;
	
	@FindBy (xpath = "(//fieldset/button)")
	WebElement publishBtn;
	
	@FindBy (xpath = "(//h1)")
	WebElement createdArtTitle;
	
	@FindBy (linkText = "Edit Article")
	WebElement editArticle;
	
	
	public CreateArticlePg(WebDriver driver) {
		PageFactory.initElements(driver,this);
	}
	
	//Actions
	        	

        public void goToNewArticle() {
        	createArticleLink.click();
        }
        
//        String title;
        
		public void enterDetails(String titleName, String desc, String body, String tagss) {
//			title = titleName;
//			System.out.println(title);
			articleTitle.sendKeys(titleName);
			description.sendKeys(desc);
			articleBody.sendKeys(body);
			tags.sendKeys(tagss);
			publishBtn.click();
			
			
		}
	public void publishArticle() {
		publishBtn.click();
	}
   
	public boolean isArticleAdded() {
	
		if (editArticle.isDisplayed()) {
			return true;
		} else {
			return false;
		}
	}
//	
	}