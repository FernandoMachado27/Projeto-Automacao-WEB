package br.com.fernando.advantagedemo.acceptance.steps;

import java.io.IOException;

import org.junit.Assert;

import br.com.fernando.advantagedemo.pages.RegisterPage;
import br.com.fernando.advantagedemo.cucumber.TestContext;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;

public class RegisterSteps {
	
	private RegisterPage paginaDeCadastro;
	private TestContext testContext;
	
	public RegisterSteps(TestContext context) throws IOException {
		this.testContext = context;
		this.paginaDeCadastro = testContext.getPageObjectManager().getRegisterPage();
	}
	
	// CADASTRO PELO EXCEL
	
	@E("preenche o formulario com dados validos do excel")
	public void preenche_o_formulario_com_dados_validos_do_excel() {
		this.paginaDeCadastro.preencherUsername(1);
		this.paginaDeCadastro.preencherEmail(1);
		this.paginaDeCadastro.preencherSenha(1);
		this.paginaDeCadastro.preencherConfirmSenha(1);
		this.paginaDeCadastro.preencherNome(1);
		this.paginaDeCadastro.preencherSobrenome(1);
		this.paginaDeCadastro.preencherCelular(1);
		this.paginaDeCadastro.preencherPais(1);
		this.paginaDeCadastro.preencherCidade(1);
		this.paginaDeCadastro.preencherEndereço(1);
		this.paginaDeCadastro.preencherEstado(1);
		this.paginaDeCadastro.preencherCodigoPostal(1);
		this.paginaDeCadastro.concordaComOsTermosDeUso(true);
	}
	
	@E("tenta se logar")
	public void tenta_se_logar() {
		this.paginaDeCadastro.efetuaCadastro();
	}
	
	// CADASTRO INVÁLIDO PELO EXCEL
	
	@E("preenche o formulario com email invalido do excel")
	public void preenche_o_formulario_com_email_invalido_do_excel() {
		this.paginaDeCadastro.preencherUsername(2);
		this.paginaDeCadastro.preencherEmail(2);
		this.paginaDeCadastro.preencherSenha(2);
		this.paginaDeCadastro.preencherConfirmSenha(2);
		this.paginaDeCadastro.preencherNome(2);
		this.paginaDeCadastro.preencherSobrenome(2);
		this.paginaDeCadastro.preencherCelular(2);
		this.paginaDeCadastro.preencherPais(2);
		this.paginaDeCadastro.preencherCidade(2);
		this.paginaDeCadastro.preencherEndereço(2);
		this.paginaDeCadastro.preencherEstado(2);
		this.paginaDeCadastro.preencherCodigoPostal(2);
		this.paginaDeCadastro.concordaComOsTermosDeUso(true);
	}
	
	@Entao("continua na pagina de cadastro com mensagem de email invalido")
	public void continua_na_pagina_de_cadastro_com_mensagem_de_email_invalido() throws InterruptedException {
		Assert.assertTrue(this.paginaDeCadastro.paginaContemMensagemDeEmailInvalido());
		Assert.assertTrue(this.paginaDeCadastro.isPaginaDeCadastro());
	}
	
	// CADASTRO PREENCHENDO APENAS CAMPO DE EMAIL
	
	@E("preenche apenas o campo de email")
	public void preenche_apenas_o_campo_de_email() {
		this.paginaDeCadastro.digiteEmail("fernando2@testando.com");
		this.paginaDeCadastro.concordaComOsTermosDeUso(true);
	}
	
	@Entao("continua na pagina de cadastro com mensagem de username pass e confirmPass invalidos")
	public void continua_na_pagina_de_cadastro_com_mensagem_de_username_pass_e_confirmPass_invalidos() {
		Assert.assertTrue(paginaDeCadastro.paginaContemMensagemUserPassEConfirmPassInvalidos());
	}
}

