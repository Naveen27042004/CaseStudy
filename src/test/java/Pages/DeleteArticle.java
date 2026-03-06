package Pages;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteArticle {
	WebDriver driver;
	@FindBy(xpath="//button[contains(text(),'Delete Article')]")
	WebElement deletearticle;
	
	@FindBy(xpath="//button[@class='nav-link']")
	WebElement feed;
	
	@FindAll(@FindBy(tagName="hi"))
	List<WebElement> tag;
	
	
	
	public DeleteArticle(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void removeArticle(String Articletitle) {
		deletearticle.click();
		String parentwindow = driver.getWindowHandle();
		
		
		Alert deletealert = driver.switchTo().alert();
		((Alert) deletearticle).accept();
		
		driver.switchTo().window(parentwindow);
		feed.click();
				
	}
	
	public boolean ArticleDeleted(String title) {
		String tmptitle1;
		for(int i=0 ; i<tag.size() ; i++) {
			tmptitle1 = tag.get(i).getText();
			if(!tmptitle1.equalsIgnoreCase(title)) {
				System.out.println("Article Deletion is Successfull");
				return true;
			}
		}
		return false;
		
	}
	
}
