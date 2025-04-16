package runners;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		
		features = ".//src//test//resources//taggedFeatures//",
		glue= {"stepDefs"},
		monochrome=true,
		//plugin = {"pretty"},
		//tags = "@SmokeTest",
//		tags = "@SmokeTest or @RegressionTest"
//		tags = "@SmokeTest and @RegressionTest"
//		tags = "not @SmokeTest and not @RegressionTest"
//		tags = "@PhaseOne"
		tags = "@PhaseOne and @SmokeTest"
//		tags = "@PhaseOne and @SmokeTest  or @PhaseTwo and @SmokeTest"
		
		)

public class ArticleRunner extends AbstractTestNGCucumberTests{

}
