package br.com.fernando.advantagedemo.acceptance.steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


import br.com.fernando.advantagedemo.cucumber.TestContext;
import br.com.fernando.advantagedemo.managers.PageObjectManager;
import br.com.fernando.advantagedemo.managers.WebDriverManage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class Hooks {

	TestContext testContext;
	private WebDriverManage webDriverManager;
	private PageObjectManager pageObjectManager;

	public Hooks(TestContext context) {
		testContext = context; // n�o damos new pois o objeto PicoContainer � invisivel, serve como o injetor de uma depend�ncia, n�o � necess�rio criar uma nova inst�ncia
	}

	/*
	 * N�o iniciamos nosso driver no m�todo @Before, porque estamos fazendo o mesmo
	 * no construtor da classe TestContext. Porque nosso PageObjectModel precisa do
	 * driver no est�gio inicial, pois ele instancia os objetos. 
	 * Como as steps foram separadas, precisa de WebDriverManager e PageObjectManager em cada steps
	 */

	@AfterStep
	public void addScreenshot(Scenario scenario){

	      final byte[] screenshot = ((TakesScreenshot) testContext.getWebDriverManager().getDriver()).getScreenshotAs(OutputType.BYTES);
	      scenario.attach(screenshot, "image/png", "image"); 
		
	}
	
	@After
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();
		System.out.println("Encerrando browser");
	}
	

}