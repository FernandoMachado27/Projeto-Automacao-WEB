package br.com.fernando.advantagedemo.acceptance.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.devtools.v85.browser.Browser;

import br.com.fernando.advantagedemo.cucumber.TestContext;
import br.com.fernando.advantagedemo.managers.PageObjectManager;
import br.com.fernando.advantagedemo.managers.WebDriverManage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	TestContext testContext;
	private WebDriverManage webDriverManager;
	private WebDriver browser;
	private PageObjectManager pageObjectManager;

	public Hooks(TestContext context) {
		testContext = context; // n�o damos new pois o objeto PicoContainer � invisivel
	}

	// N�o iniciamos nosso driver no m�todo @Before, porque estamos fazendo o mesmo
	// no construtor da classe TestContext. Porque nosso PageObjectModel precisa do
	// driver no est�gio inicial. Pois ele instancia os objetos. 
	// Como as steps foram separadas, precisa de WebDriverManager e PageObjectManager em cada steps

	@After
	public void AfterSteps() {
		testContext.getWebDriverManager().closeDriver();
		System.out.println("Encerrando browser");
	}

}