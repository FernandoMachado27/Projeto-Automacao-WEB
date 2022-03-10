package br.com.fernando.advantagedemo.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", tags = "@cadastro", plugin = { "pretty",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" })
public class CucumberRunner {
	
/* reports:
 * "junit:target/cucumber-report/Cucumber.xml",
 * "html:target/cucumber-reports"
 */

}
