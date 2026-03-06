package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
	features = "src\\test\\resources\\features",
	glue = {"Stepdef"},
	dryRun = true,
	monochrome = true,
	plugin = {"pretty" , "html:test-output/report/HTMLReport.html",
			  "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
)

public class ArticleCRUD extends AbstractTestNGCucumberTests{

}
