package br.com.fernando.advantagedemo.acceptance.steps;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import br.com.fernando.advantagedemo.cucumber.TestContext;
import br.com.fernando.advantagedemo.dataProviders.ConfigFileReader;
import br.com.fernando.advantagedemo.managers.FileReaderManager;
import br.com.fernando.advantagedemo.managers.PageObjectManager;
import br.com.fernando.advantagedemo.managers.WebDriverManager;
import br.com.fernando.advantagedemo.pages.HomePage;
import br.com.fernando.advantagedemo.pages.SearchPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class SearchSteps {
	
	private SearchPage paginaDePesquisa;
	private WebDriver browser;
	private PageObjectManager pageObjectManager;
	private HomePage homePage;
	private ConfigFileReader configFileReader;
	private WebDriverManager webDriverManager;
	private TestContext testContext;
	
	public SearchSteps(TestContext context) {
		this.testContext = context;
		this.homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Dado("o usuario esta na pagina inicial e acessa a area de pesquisa")
	public void o_usuario_esta_na_pagina_inicial_e_acessa_a_area_de_pesquisa() {
		this.homePage.paginaInicial();
		this.paginaDePesquisa = this.homePage.acessarAreaDePesquisa();
	}

	@Quando("pesquisa um produto")
	public void pesquisa_um_produto() {
		this.paginaDePesquisa.pesquisarProduto("HP ELITEPAD 1000 G2 TABLET");
	}
	
	@Entao("o produto e encontrado com sucesso")
	public void o_produto_e_encontrado_com_sucesso() {
		Assert.assertTrue(this.paginaDePesquisa.contemProdutoPesquisado("HP ELITEPAD 1000 G2 TABLET"));
	}
	
	@Quando("pesquisa um produto que nao existe")
	public void pesquisa_um_produto_que_nao_existe() {
		this.paginaDePesquisa.pesquisarProduto("watch");
	}

	@Entao("o produto nao e encontrado")
	public void o_produto_nao_e_encontrado() {
		Assert.assertTrue(this.paginaDePesquisa.mensagemDeProdutoNaoEncontrado());
	}

}
