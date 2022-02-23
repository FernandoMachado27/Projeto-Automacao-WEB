package br.com.fernando.advantagedemo.acceptance.steps;

import br.com.fernando.advantagedemo.cucumber.TestContext;
import br.com.fernando.advantagedemo.pages.HomePage;

public class HomeSteps {
	
	private TestContext testContext;
	private HomePage homePage;
	
	public HomeSteps(TestContext context) {
		this.testContext = context;
		this.homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	

}
