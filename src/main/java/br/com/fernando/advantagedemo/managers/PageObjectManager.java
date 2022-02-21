package br.com.fernando.advantagedemo.managers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import br.com.fernando.advantagedemo.pages.HomePage;
import br.com.fernando.advantagedemo.pages.LoginPage;
import br.com.fernando.advantagedemo.pages.RegisterPage;
import br.com.fernando.advantagedemo.pages.SearchPage;

public class PageObjectManager { // gerenciador de objetos da pagina

	private WebDriver browser;
	private HomePage homePage;
	private LoginPage loginPage;
	private RegisterPage registerPage;
	private SearchPage searchPage;

	public PageObjectManager(WebDriver browser) {
		this.browser = browser;
	}
	
	public HomePage getHomePage(){

		return (homePage == null) ? homePage = new HomePage(browser) : homePage; // cria um obj da classe se ele for nulo

	}

	

	public LoginPage getLoginPage() {

		return (loginPage == null) ? loginPage = new LoginPage(browser) : loginPage;

	}

	

	public RegisterPage getRegisterPage() throws IOException {

		return (registerPage == null) ? registerPage = new RegisterPage(browser) : registerPage;

	}

	

	public SearchPage getSearchPage() {

		return (searchPage == null) ? searchPage = new SearchPage(browser) : searchPage;

	}
}


