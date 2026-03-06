package Stepdef;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import Base.TestBase;
import Pages.DeleteArticle;
import Pages.EditArticle;
import Pages.LoginPage;
import Pages.NewArticle;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ArticleStepdef {
	WebDriver driver;
	LoginPage loginpage;
	NewArticle newarticle;
	EditArticle editarticle;
	DeleteArticle deletearticle;
	
	public ArticleStepdef() {
		driver=TestBase.getdriver();
		loginpage = new LoginPage(driver);
		newarticle = new NewArticle(driver);
		editarticle = new EditArticle(driver);
		deletearticle = new DeleteArticle(driver);
		
	}
@Given("User is on Login Page")
public void user_is_on_login_page() {
	TestBase.openUrl("https://conduit-realworld-example-app.fly.dev/#/login");
}

@When("User enters {string} and {string}")
public void user_enters_and(String struser, String strpwd) {
	loginpage.loginIntoapp(struser, strpwd);
}

@Given("User in Home Page")
public void user_in_home_page() {
	Assert.assertTrue(loginpage.loginpage());
}
@When("User create new article {string} {string} {string} {string}")
public void user_create_new_article(String articletitle, String articledescription, String articlemain, String articletag) {
    newarticle.articleinput(articletitle, articledescription, articlemain, articletag);
}
@Then("Article is created {string}")
public void article_is_created(String strtitle) throws InterruptedException {
    Assert.assertTrue(newarticle.articlecreated(strtitle));
}


@When("User updates article")
public void user_updates_article(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	List<List<String>> edittitle = dataTable.asLists();
	String title = edittitle.get(0).get(0);
	editarticle.Articleupdate(title);
}

@Then("Article is Updated {string}")
public void article_is_updated(String strtitle) throws InterruptedException {
    Assert.assertTrue(editarticle.Articleupdate(strtitle));
}

//
//@Given("User is on Login Page")
//public void user_is_on_login_page() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//@When("User enters {string} and {string}")
//public void user_enters_and(String string, String string2) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//@Then("User in Home Page")
//public void user_in_home_page() {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
//
//
//@Given("Article is Created {string}")
//public void article_is_created(String string) {
//    // Write code here that turns the phrase above into concrete actions
//    throw new io.cucumber.java.PendingException();
//}
@When("User Deletes article")
public void user_deletes_article(io.cucumber.datatable.DataTable dataTable) {
    List<Map<String,String>> edittitle = dataTable.asMaps();
    String title = edittitle.get(0).get(edittitle);
    deletearticle.removeArticle(title);
}
@Then("Article is Deleted {string}")
public void article_is_deleted(String strtitle) {
	Assert.assertTrue(deletearticle.ArticleDeleted(strtitle));
}

}