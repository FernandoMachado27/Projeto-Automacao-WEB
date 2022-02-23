package br.com.fernando.advantagedemo.acceptance.steps;

import org.junit.Assert;

import br.com.fernando.advantagedemo.cucumber.TestContext;
import br.com.fernando.advantagedemo.pages.HomePage;
import br.com.fernando.advantagedemo.pages.SearchPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class HomeSteps {
	
	private TestContext testContext;
	private HomePage homePage;
	
	public HomeSteps(TestContext context) {
		this.testContext = context;
		this.homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	// REGISTER
	
	@Dado("o usuario acessa o site")
	public void o_usuario_acessa_o_site() {
		this.homePage.paginaInicial();
	}
	
	@Quando("clica para fazer login")
	public void clica_para_fazer_login() {
		this.homePage.acessarPaginaDeLogin();
	}
	
	@Entao("e redirecionado para a pagina inicial")
	public void e_redirecionado_para_a_pagina_inicial() {
		Assert.assertTrue(homePage.validarNomeDeUsuario());
	}
	
	// SEARCH
	
	@Dado("o usuario abre o site")
	public void o_usuario_abre_o_site() {
		this.homePage.paginaInicial();
	}
	
	@Quando("acessa a area de pesquisa")
	public void acessa_a_area_de_pesquisa() {
		this.homePage.acessarAreaDePesquisa();
	}
	
	
	@E("pesquisa um produto")
	public void pesquisa_um_produto() {
		this.homePage.pesquisarProduto("HP ELITEPAD 1000 G2 TABLET");
	}
	
	@E("pesquisa um produto que nao existe")
	public void pesquisa_um_produto_que_nao_existe() {
		this.homePage.pesquisarProduto("watch");
	}
	
	
	// LOGIN
	
	@Dado("o usuario entra no site")
	public void o_usuario_entra_no_site() {
		this.homePage.paginaInicial();
	}
	
	@Quando("entra na area de login")
	public void entra_na_area_de_login() {
		this.homePage.acessarPaginaDeLogin();
	}
	
	@Entao("login completo")
	public void login_completo() {
	Assert.assertTrue(this.homePage.validarNomeDeUsuario());
}
	

}
