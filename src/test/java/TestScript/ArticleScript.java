package TestScript;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.TestBase;
import Pages.DeleteArticle;
import Pages.EditArticle;
import Pages.LoginPage;
import Pages.NewArticle;

public class ArticleScript {
	WebDriver driver;
	LoginPage loginpage;
	NewArticle newarticle;
	EditArticle editarticle;
	DeleteArticle deletearticle;
	int num=04 ;
	String strTit;
	
	@BeforeTest
	public void setup() {
		TestBase.initDriver();
		driver = TestBase.getdriver();
		TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");
		loginpage = new LoginPage(driver);
		newarticle = new NewArticle(driver);
		editarticle = new EditArticle(driver);
		deletearticle = new DeleteArticle(driver);
	}
	@Test(priority = 1)
	public void logintest() {
		System.out.println("Login Page");
		loginpage.loginIntoapp("sample@gmail.com", "Sample");
	}
	
	@Test(priority = 2)
	public void newarticletest() {
		strTit = "Selenium" + String.valueOf(num);
		newarticle.articleinput(strTit, "Selenium Training", "Selenium WebDriver Training", "#Selenium");
		System.out.println("Article Created Succefully " + strTit);
	}
	
	@Test(priority = 3)
	public void EditArticleTest() throws InterruptedException{
		strTit = "Selenium Webdriver";
		editarticle.updatearticle(strTit);
		System.out.println("Article Updated Successfully " + strTit);
	}
	
	@Test(priority = 4)
	
	public void DeleteArticleTest() throws InterruptedException{
		deletearticle.removeArticle(strTit);
		System.out.println(strTit + " Article Deleted Successfully");
	}
}
