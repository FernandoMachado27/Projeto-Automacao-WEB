package br.com.fernando.advantagedemo.acceptance.steps;

import org.junit.Assert;

import br.com.fernando.advantagedemo.pages.CadastroPage;
import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastroSteps {
	
	private PaginaInicial paginaInicial;
	private LoginPage paginaDeLogin;
	private CadastroPage paginaDeCadastro;
	
	@Dado("o usuario acessa pagina de cadastro")
	public void o_usuario_acessa_pagina_de_cadastro() throws InterruptedException {
		this.paginaInicial = new PaginaInicial();
		this.paginaDeLogin = this.paginaInicial.acessarPaginaDeLogin();
		this.paginaDeCadastro = this.paginaDeLogin.criarNovoCadastro();
		
	}

	@Quando("preenche o formulario com dados validos")
	public void preenche_o_formulario_com_dados_validos() {
		this.paginaDeCadastro.nomeEEmailDoNovoUsuario("Fernando217", "fernando2@testando.com");
		this.paginaDeCadastro.digiteASenhaEConfirme("12345aA", "12345aA");
		this.paginaDeCadastro.digiteNomeESobrenome("Fernando", "Testando");
		this.paginaDeCadastro.digiteNumeroDeCelular("11999272728");
		this.paginaDeCadastro.digiteSeuPaisDeOrigem("Brazil");
		this.paginaDeCadastro.digiteSuaCidade("São Paulo");
		this.paginaDeCadastro.digiteSeuEndereco("Estrada São Paulo");
		this.paginaDeCadastro.digiteSeuEstado("São Paulo");
		this.paginaDeCadastro.digiteOCodigoPostal("06364000");
		this.paginaDeCadastro.concordaComOsTermosDeUso("Sim");
	}
	
	@Quando("realiza o cadastro")
	public void realiza_o_cadastro() throws InterruptedException {
		this.paginaDeCadastro.efetuaCadastro();
	}
	
	@Entao("eh redirecionado para a pagina inicial")
	public void eh_redirecionado_para_a_pagina_inicial() {
		Assert.assertTrue(this.paginaDeCadastro.isPaginaInicial());
		this.paginaDeCadastro.fechar();
	}
	
	@Quando("preenche o formulario com email invalido")
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
		this.paginaDeCadastro.concordaComOsTermosDeUso("Sim");
	}

	@Quando("tenta se logar")
	public void tenta_se_logar() throws InterruptedException {
		this.paginaDeCadastro.efetuaCadastro();
	}
	
	@Entao("continua na pagina de cadastro com mensagem de email invalido")
	public void continua_na_pagina_de_cadastro_com_mensagem_de_email_invalido() {
		Assert.assertTrue(this.paginaDeCadastro.paginaContemMensagemDeEmailInvalido());
		Assert.assertTrue(this.paginaDeCadastro.isPaginaDeCadastro());
		this.paginaDeCadastro.fechar();
	}
}

