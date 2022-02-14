package br.com.fernando.advantagedemo.acceptance.steps;

import java.io.IOException;

import org.junit.Assert;

import br.com.fernando.advantagedemo.pages.CadastroPage;
import br.com.fernando.advantagedemo.pages.LoginPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class CadastroSteps {
	
	private PaginaInicial paginaInicial;
	private LoginPage paginaDeLogin;
	private CadastroPage paginaDeCadastro;
	
	@Dado("o usuario acessa pagina de cadastro")
	public void o_usuario_acessa_pagina_de_cadastro() throws IOException, InterruptedException {
		this.paginaInicial = new PaginaInicial();
		this.paginaDeLogin = this.paginaInicial.acessarPaginaDeLogin();
		this.paginaDeCadastro = this.paginaDeLogin.criarNovoCadastro();
		
	}
	
	// CADASTRO COM DADOS VALIDOS

	@Quando("preenche o formulario com dados validos")
	public void preenche_o_formulario_com_dados_validos() {
		this.paginaDeCadastro.nomeEEmailDoNovoUsuario("Fernando252", "fernando2@testando.com");
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
	
	@Quando("tenta se logar")
	public void tenta_se_logar() {
		this.paginaDeCadastro.efetuaCadastro();
	}
	
	@Entao("eh redirecionado para a pagina inicial")
	public void eh_redirecionado_para_a_pagina_inicial() {
		Assert.assertTrue(paginaDeCadastro.validarNomeDeUsuario());
		this.paginaDeCadastro.fechar();
	}
	
	// CADASTRO COM EMAIL INVÁLIDO
	
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
		this.paginaDeCadastro.concordaComOsTermosDeUso(true);
	}
	
	@Entao("continua na pagina de cadastro com mensagem de email invalido")
	public void continua_na_pagina_de_cadastro_com_mensagem_de_email_invalido() {
		Assert.assertTrue(this.paginaDeCadastro.paginaContemMensagemDeEmailInvalido());
		Assert.assertTrue(this.paginaDeCadastro.isPaginaDeCadastro());
		this.paginaDeCadastro.fechar();
	}
	
	// CADASTRO PELO EXCEL
	
	@Quando("preenche o formulario com dados validos do excel")
	public void preenche_o_formulario_com_dados_validos_do_excel() {
		this.paginaDeCadastro.preencheFormularioPeloExcel(1);
		this.paginaDeCadastro.concordaComOsTermosDeUso(true);
	}
	
	// CADASTRO INVÁLIDO PELO EXCEL
	
	@Quando("preenche o formulario com email invalido do excel")
	public void preenche_o_formulario_com_email_invalido_do_excel() {
		this.paginaDeCadastro.preencheFormularioPeloExcel(2);
		this.paginaDeCadastro.concordaComOsTermosDeUso(true);
	}
	
	// CADASTRO PREENCHENDO APENAS CAMPO DE EMAIL
	
	@Quando("preenche apenas o campo de email")
	public void preenche_apenas_o_campo_de_email() {
		this.paginaDeCadastro.nomeEEmailDoNovoUsuario(" ", "fernando2@testando.com");
		this.paginaDeCadastro.digiteASenhaEConfirme(" ", " ");
		this.paginaDeCadastro.concordaComOsTermosDeUso(true);
	}
	
	@Entao("continua na pagina de cadastro com mensagem de username pass e confirmPass invalidos")
	public void continua_na_pagina_de_cadastro_com_mensagem_de_username_pass_e_confirmPass_invalidos() {
		Assert.assertTrue(paginaDeCadastro.paginaContemMensagemUserPassEConfirmPassInvalidos());
		this.paginaDeCadastro.fechar();
	}
}

