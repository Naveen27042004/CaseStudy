package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),'Login)]")
	WebElement loginbtn;
	
	@FindBy(linkText = "New Article")
	WebElement newarticle;
	
	@FindBy(xpath = "//img[@alt='Sample']")
	WebElement succlogin;
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void loginIntoapp(String struser , String strpwd)
	{
		System.out.println("Login Method");
		email.sendKeys(struser);
		password.sendKeys(strpwd);
		loginbtn.click();
		newarticle.click();
		
	}
	
	public boolean loginpage() {
		if(succlogin.isDisplayed()) {
			System.out.println("Login is Successfull!!!");
			return true;
		}
		else {
			return false;
		}
	}
	
}
