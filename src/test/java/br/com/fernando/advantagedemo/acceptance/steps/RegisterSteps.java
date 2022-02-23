package br.com.fernando.advantagedemo.acceptance.steps;

import java.io.IOException;

import org.junit.Assert;

import br.com.fernando.advantagedemo.pages.RegisterPage;
import br.com.fernando.advantagedemo.pages.LoginPage;
import br.com.fernando.advantagedemo.cucumber.TestContext;
import br.com.fernando.advantagedemo.pages.HomePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class RegisterSteps {
	
	private LoginPage paginaDeLogin;
	private RegisterPage paginaDeCadastro;
	private HomePage homePage;
	private TestContext testContext;
	
	public RegisterSteps(TestContext context) {
		this.testContext = context;
		this.homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Dado("o usuario acessa o site")
	public void o_usuario_acessa_o_site() {
		this.homePage.paginaInicial();
	}
	
	@Quando("clica para fazer login")
	public void clica_para_fazer_login() {
		this.paginaDeLogin = this.homePage.acessarPaginaDeLogin();
	}
	
	@E("clica para criar nova conta")
	public void clica_para_criar_nova_conta() throws IOException, InterruptedException {
		this.paginaDeCadastro = this.paginaDeLogin.criarNovoCadastro();
	}
	
	// CADASTRO COM DADOS VALIDOS

	@E("preenche o formulario com dados validos")
	public void preenche_o_formulario_com_dados_validos() {
		this.paginaDeCadastro.nomeEEmailDoNovoUsuario("Fernando258", "fernando2@testando.com");
		this.paginaDeCadastro.digiteASenhaEConfirme("12345aA", "12345aA");
		this.paginaDeCadastro.digiteNomeESobrenome("Fernando", "Testando");
		this.paginaDeCadastro.digiteNumeroDeCelular("11999272728");
		this.paginaDeCadastro.digiteSeuPaisDeOrigem("Brazil");
		this.paginaDeCadastro.digiteSuaCidade("São Paulo");
		this.paginaDeCadastro.digiteSeuEndereco("Estrada São Paulo");
		this.paginaDeCadastro.digiteSeuEstado("São Paulo");
		this.paginaDeCadastro.digiteOCodigoPostal("06364000");
		this.paginaDeCadastro.concordaComOsTermosDeUso(true);
	}
	
	@E("tenta se logar")
	public void tenta_se_logar() {
		this.paginaDeCadastro.efetuaCadastro();
	}
	
	@Entao("e redirecionado para a pagina inicial")
	public void e_redirecionado_para_a_pagina_inicial() {
		Assert.assertTrue(paginaDeCadastro.validarNomeDeUsuario());
	}
	
	// CADASTRO COM EMAIL INVÁLIDO
	
	@E("preenche o formulario com email invalido")
	public void preenche_o_formulario_com_email_invalido() {
		this.paginaDeCadastro.nomeEEmailDoNovoUsuario("Fernando44", "fernando2");
		this.paginaDeCadastro.digiteASenhaEConfirme("12345aA", "12345aA");
		this.paginaDeCadastro.digiteNomeESobrenome("Fernando", "Fernandes");
		this.paginaDeCadastro.digiteNumeroDeCelular("11999272728");
		this.paginaDeCadastro.digiteSeuPaisDeOrigem("Brazil");
		this.paginaDeCadastro.digiteSuaCidade("São Paulo");
		this.paginaDeCadastro.digiteSeuEndereco("Estrada São Paulo");
		this.paginaDeCadastro.digiteSeuEstado("São Paulo");
		this.paginaDeCadastro.digiteOCodigoPostal("06364000");
		this.paginaDeCadastro.concordaComOsTermosDeUso(true);
	}
	
	@Entao("continua na pagina de cadastro com mensagem de email invalido")
	public void continua_na_pagina_de_cadastro_com_mensagem_de_email_invalido() {
		Assert.assertTrue(this.paginaDeCadastro.paginaContemMensagemDeEmailInvalido());
		Assert.assertTrue(this.paginaDeCadastro.isPaginaDeCadastro());
	}
	
	// CADASTRO PELO EXCEL
	
	@E("preenche o formulario com dados validos do excel")
	public void preenche_o_formulario_com_dados_validos_do_excel() {
		this.paginaDeCadastro.preencheFormularioPeloExcel(1);
		this.paginaDeCadastro.concordaComOsTermosDeUso(true);
	}
	
	// CADASTRO INVÁLIDO PELO EXCEL
	
	@E("preenche o formulario com email invalido do excel")
	public void preenche_o_formulario_com_email_invalido_do_excel() {
		this.paginaDeCadastro.preencheFormularioPeloExcel(2);
		this.paginaDeCadastro.concordaComOsTermosDeUso(true);
	}
	
	// CADASTRO PREENCHENDO APENAS CAMPO DE EMAIL
	
	@E("preenche apenas o campo de email")
	public void preenche_apenas_o_campo_de_email() {
		this.paginaDeCadastro.nomeEEmailDoNovoUsuario(" ", "fernando2@testando.com");
		this.paginaDeCadastro.digiteASenhaEConfirme(" ", " ");
		this.paginaDeCadastro.concordaComOsTermosDeUso(true);
	}
	
	@Entao("continua na pagina de cadastro com mensagem de username pass e confirmPass invalidos")
	public void continua_na_pagina_de_cadastro_com_mensagem_de_username_pass_e_confirmPass_invalidos() {
		Assert.assertTrue(paginaDeCadastro.paginaContemMensagemUserPassEConfirmPassInvalidos());
	}
}

