package br.com.fernando.advantagedemo.acceptance.steps;

import java.io.IOException;

import org.junit.Assert;

import br.com.fernando.advantagedemo.pages.LoginPage;
import br.com.fernando.advantagedemo.cucumber.TestContext;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;

public class LoginSteps {
	
	private LoginPage paginaDeLogin;
	private TestContext testContext;
	
	public LoginSteps(TestContext context) {
		this.testContext = context;
		this.paginaDeLogin = testContext.getPageObjectManager().getLoginPage();
	}
	
	@E("clica para criar nova conta")
	public void clica_para_criar_nova_conta() throws IOException, InterruptedException {
		this.paginaDeLogin.criarNovoCadastro();
	}
	
	@E("preenche os dados corretos")
	public void preenche_os_dados_corretos() throws Throwable {
		this.paginaDeLogin.preencherUsername("admin");
		this.paginaDeLogin.preencherPassword("adm1n");
	}
	
	@E("clica para logar")
	public void clica_para_logar() {
		this.paginaDeLogin.logar();
	}
	
	@E("preenche um dos dados incorretamente")
	public void preenche_um_dos_dados_incorretamente() throws InterruptedException {
		this.paginaDeLogin.preencherUsername("admin");
		this.paginaDeLogin.preencherPassword("1");
	}
	
	@Entao("nao foi possivel concluir o login")
	public void nao_foi_possivel_concluir_o_login() {
		Assert.assertTrue(this.paginaDeLogin.contemMensagemDeErro()); 
	}
}
