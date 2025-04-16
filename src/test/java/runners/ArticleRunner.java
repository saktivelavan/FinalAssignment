package runners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = ".//src//test//resources//features//",
		glue= {"stepDefs"},
		monochrome=true,
		plugin = {"pretty",
				"html:target/reports/HtmlReport.html"}
				
		)

public class ArticleRunner extends AbstractTestNGCucumberTests{

}
