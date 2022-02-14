package br.com.fernando.advantagedemo.acceptance.steps;

import org.junit.Assert;

import br.com.fernando.advantagedemo.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {
	
	private PaginaInicial paginaInicial;
	private LoginPage paginaDeLogin;
	
	@Dado("o usuario acessa pagina de login")
	public void o_usuario_acessa_pagina_de_login() {
		this.paginaInicial = new PaginaInicial();
		this.paginaDeLogin = this.paginaInicial.acessarPaginaDeLogin();
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
		this.paginaDeLogin.fechar();
	}
	
	@Quando("preenche um dos dados incorretamente")
	public void preenche_um_dos_dados_incorretamente() {
		this.paginaDeLogin.preencherUsername("admin");
		this.paginaDeLogin.preencherPassword("1");
	}
	
	@Entao("nao foi possivel concluir o login")
	public void nao_foi_possivel_concluir_o_login() {
		Assert.assertTrue(this.paginaDeLogin.contemMensagemDeErro()); 
		this.paginaDeLogin.fechar();
	}
}
