package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EditArticle {
	WebDriver driver;
	WebDriverWait expWait;
	
	@FindBy(xpath="//a[text()= ' Edit Article']")
	WebElement editarticle;
	
	@FindBy(xpath = "//input[@name='title']")
	WebElement articletitle;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement updatearticle;
	
	@FindBy(tagName = "hi")
	WebElement checkupdate;
	
	public EditArticle(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		expWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
	}
	public void updatearticle(String strtitle) {
		editarticle.click();
		articletitle.click();
		articletitle.sendKeys(strtitle);
		updatearticle.click();
	}
	
	public boolean Articleupdate(String strtit) throws InterruptedException{
		expWait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.tagName("h1")), strtit));
		
		if(checkupdate.isDisplayed()) {
			System.out.println("Article Update is Successfull!!"+checkupdate.getText());
			return true;
		}
		else {
			return false;
		}
	}
	
}
