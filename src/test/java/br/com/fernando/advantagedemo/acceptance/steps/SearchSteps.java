package br.com.fernando.advantagedemo.acceptance.steps;

import org.junit.Assert;

import br.com.fernando.advantagedemo.cucumber.TestContext;
import br.com.fernando.advantagedemo.pages.SearchPage;
import io.cucumber.java.pt.Entao;

public class SearchSteps {
	
	private SearchPage paginaDePesquisa;
	private TestContext testContext;
	
	public SearchSteps(TestContext context) {
		this.testContext = context;
		this.paginaDePesquisa = testContext.getPageObjectManager().getSearchPage();
	}
	
	@Entao("o produto e encontrado com sucesso")
	public void o_produto_e_encontrado_com_sucesso() {
		Assert.assertTrue(this.paginaDePesquisa.contemProdutoPesquisado("HP ELITEPAD 1000 G2 TABLET"));
	}
	
	@Entao("o produto nao e encontrado")
	public void o_produto_nao_e_encontrado() {
		Assert.assertTrue(this.paginaDePesquisa.mensagemDeProdutoNaoEncontrado());
	}

}
