package br.com.fernando.advantagedemo.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", tags = "@login", plugin = { "pretty", "junit:target/cucumber-report/Cucumber.xml", "html:target/cucumber-reports" })
public class CucumberRunner {

}
