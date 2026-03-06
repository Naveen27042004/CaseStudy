package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewArticle {
	WebDriver driver;
	WebDriverWait expwait;
	
	@FindBy(xpath="//input[@name='title']")
	WebElement articletitle;
	
	@FindBy(xpath="//input[@name='description']")
	WebElement articledescription;
	
	@FindBy(xpath = "//textarea[@name='body']")
	WebElement articlemain;
	
	@FindBy(xpath = "//input[@name='tags]")
	WebElement articletag;
	
	@FindBy(xpath = "//button[@type='submit]")
	WebElement publisharticle;
	
	@FindBy(tagName = "h1")
	WebElement checknewarticle;
	
	public NewArticle(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		expwait = new WebDriverWait(driver,Duration.ofSeconds(20));
	}
	
	public void articleinput(String strtitle , String strdescription , String strmain , String strtag) {
		articletitle.sendKeys(strtitle);
		articledescription.sendKeys(strdescription);
		articlemain.sendKeys(strmain);
		articletag.sendKeys(strtag);
		publisharticle.click();
	}
	
	public boolean articlecreated(String strtit) {
		expwait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.tagName("h1")), strtit));
		if(checknewarticle.isDisplayed()){
			System.out.println("Article Creation is Successfull!");
			return true;
		}
		else {
			return false;
		}
	}
	
}
