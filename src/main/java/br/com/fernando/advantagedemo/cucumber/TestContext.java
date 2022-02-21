package br.com.fernando.advantagedemo.cucumber;

import org.openqa.selenium.WebDriver;

import br.com.fernando.advantagedemo.managers.PageObjectManager;
import br.com.fernando.advantagedemo.managers.WebDriverManager;

public class TestContext {
	
	private WebDriverManager webDriverManager;
	private PageObjectManager pageObjectManager;
	private WebDriver browser;
	
	public TestContext(){
		webDriverManager = new WebDriverManager(); // o construtor já pega qual browser e environment vou usar
		browser = webDriverManager.getDriver(); //cria o driver se for nulo, segundo o driver que escolhi no properties
		pageObjectManager = new PageObjectManager(browser); 
	}
	
	public WebDriverManager getWebDriverManager() {
		return webDriverManager;
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}

}