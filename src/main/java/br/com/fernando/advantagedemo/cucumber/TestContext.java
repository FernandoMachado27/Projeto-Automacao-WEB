package br.com.fernando.advantagedemo.cucumber;

import org.openqa.selenium.WebDriver;

import br.com.fernando.advantagedemo.managers.PageObjectManager;
import br.com.fernando.advantagedemo.managers.WebDriverManage;

public class TestContext {
	
	private WebDriverManage webDriverManager;
	private PageObjectManager pageObjectManager;
	private WebDriver browser;
	
	public TestContext(){ // instancia objetos
		webDriverManager = new WebDriverManage(); // o construtor já pega qual browser e environment vou usar
		browser = webDriverManager.getDriver(); //cria o driver se for nulo, segundo o driver que escolhi no properties
		pageObjectManager = new PageObjectManager(browser); // inicia o gerenciador de objetos
	}
	
	public WebDriverManage getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}