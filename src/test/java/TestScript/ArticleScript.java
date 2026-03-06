package TestScript;

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
	int artNum = 44, artNum1=404;
	String strT;
	
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
		strT = "Go Lang" + String.valueOf(artNum);
		newarticle.articleinput(strT, "Go Language", "Go Language by Google", "#GoGoogle");
	}
	
	@Test(priority = 3)
	public void EditArticleTest() throws InterruptedException{
		strT = "Go Lang"+String.valueOf(artNum1);
		editarticle.updatearticle(strT);
	}
	
	@Test(priority = 4)
	
	public void DeleteArticleTest() throws InterruptedException{
		deletearticle.removeArticle(strT);
	}
}
