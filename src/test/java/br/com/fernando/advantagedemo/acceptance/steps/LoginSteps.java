package br.com.fernando.advantagedemo.acceptance.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.fernando.advantagedemo.pages.LoginPage;
import br.com.fernando.advantagedemo.cucumber.TestContext;
import br.com.fernando.advantagedemo.dataProviders.ConfigFileReader;
import br.com.fernando.advantagedemo.managers.FileReaderManager;
import br.com.fernando.advantagedemo.managers.PageObjectManager;
import br.com.fernando.advantagedemo.managers.WebDriverManager;
import br.com.fernando.advantagedemo.pages.HomePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {
	
	private LoginPage paginaDeLogin;
	private WebDriver browser;
	private PageObjectManager pageObjectManager;
	private HomePage homePage;
	private ConfigFileReader configFileReader;
	private WebDriverManager webDriverManager;
	private TestContext testContext;
	
	public LoginSteps(TestContext context) {
		this.testContext = context;
		this.homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Dado("o usuario acessa pagina de login")
	public void o_usuario_acessa_pagina_de_login() {
		this.homePage.paginaInicial();
		this.paginaDeLogin = this.homePage.acessarPaginaDeLogin();
	}
	
	@Quando("preenche os dados corretos")
	public void preenche_os_dados_corretos() throws Throwable {
		this.paginaDeLogin.preencherUsername("admin");
		this.paginaDeLogin.preencherPassword("adm1n");
	}
	
	@Quando("clica para logar")
	public void clica_para_logar() {
		this.paginaDeLogin.logar();
	}
	
	@Entao("login completo")
		public void login_completo() {
		Assert.assertTrue(paginaDeLogin.validarNomeDeUsuario());
	}
	
	@Quando("preenche um dos dados incorretamente")
	public void preenche_um_dos_dados_incorretamente() throws InterruptedException {
		this.paginaDeLogin.preencherUsername("admin");
		this.paginaDeLogin.preencherPassword("1");
	}
	
	@Entao("nao foi possivel concluir o login")
	public void nao_foi_possivel_concluir_o_login() {
		Assert.assertTrue(this.paginaDeLogin.contemMensagemDeErro()); 
	}
}
