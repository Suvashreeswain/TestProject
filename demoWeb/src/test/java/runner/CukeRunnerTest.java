package runner;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.ExtentProperties;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * 
 * @author nimit.jain
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(

		plugin = { "com.cucumber.listener.ExtentCucumberFormatter:" },

		glue = { "com.demo.stepdefinitions" }

		, tags = { "@SwitchUser" }

		, features = { "Feature/" }

)

public class CukeRunnerTest {
	@BeforeClass
	public static void setup() {

		ExtentProperties extentProperties = ExtentProperties.INSTANCE;
		String timeStamp = new SimpleDateFormat("dd.MM.yyyy.HH.mm.ss").format(new Date());
		String userDir = System.getProperty("user.dir");
		extentProperties.setReportPath(
				userDir + "/target/CucumberReportForEveryTestWithTimeStamp/Report_" + timeStamp + ".html");
	}

}
