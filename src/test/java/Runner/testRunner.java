package Runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",//to tell cucumber where is ur feature file
        glue="Stepdef", // to tell cucumber where is ur step def code
        tags="@facebook", // to tell which tagged feature file to execute
        plugin = {"pretty", // to generate reports
        		"html:target/html/htmlreport.html",
				"json:target/json/file.json",
               
        },
        publish=true,
        monochrome=true,
        dryRun=false
)

public class testRunner {

}
