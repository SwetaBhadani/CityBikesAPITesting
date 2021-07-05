package runner;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * 
 * @author swetabhadani
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features="features",
        glue="stepDefinition"
)
public class TestCityBikesRunner {

}

