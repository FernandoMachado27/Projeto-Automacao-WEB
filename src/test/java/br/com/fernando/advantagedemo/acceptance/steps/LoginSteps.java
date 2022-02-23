package br.com.fernando.advantagedemo.acceptance.steps;

import org.junit.Assert;

import br.com.fernando.advantagedemo.pages.LoginPage;
import br.com.fernando.advantagedemo.cucumber.TestContext;
import br.com.fernando.advantagedemo.pages.HomePage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class LoginSteps {
	
	private LoginPage paginaDeLogin;
	private HomePage homePage;
	private TestContext testContext;
	
	public LoginSteps(TestContext context) {
		this.testContext = context;
		this.homePage = testContext.getPageObjectManager().getHomePage();
	}
	
	@Dado("o usuario entra no site")
	public void o_usuario_entra_no_site() {
		this.homePage.paginaInicial();
	}
	
	@Quando("entra na area de login")
	public void entra_na_area_de_login() {
		this.paginaDeLogin = this.homePage.acessarPaginaDeLogin();
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
	
	@Entao("login completo")
		public void login_completo() {
		Assert.assertTrue(paginaDeLogin.validarNomeDeUsuario());
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
