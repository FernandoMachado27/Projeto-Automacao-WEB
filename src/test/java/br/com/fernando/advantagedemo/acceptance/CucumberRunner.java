package br.com.fernando.advantagedemo.acceptance;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features", tags = " @cadastro_adicionando_apenas_email")
public class CucumberRunner {

}
	
