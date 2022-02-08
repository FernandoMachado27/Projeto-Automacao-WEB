package br.com.fernando.advantagedemo.acceptance.steps;

import org.junit.Assert;

import br.com.fernando.advantagedemo.pages.PesquisaPage;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PesquisaSteps {
	
	private PaginaInicial paginaInicial;
	private PesquisaPage paginaDePesquisa;
	
	@Dado("o usuario esta na pagina inicial e acessa a area de pesquisa")
	public void o_usuario_esta_na_pagina_inicial_e_acessa_a_area_de_pesquisa() throws InterruptedException {
		this.paginaInicial = new PaginaInicial();
		this.paginaInicial.acessarAreaDePesquisa();
	}

	@Quando("pesquisa um produto")
	public void pesquisa_um_produto() throws InterruptedException {
		this.paginaDePesquisa = this.paginaInicial.pesquisarProduto("HP ELITEPAD 1000 G2 TABLET");
	}
	
	@Entao("o produto eh encontrado com sucesso")
	public void o_produto_eh_encontrado_com_sucesso() {
		Assert.assertTrue(this.paginaDePesquisa.contemProdutoPesquisado("HP ELITEPAD 1000 G2 TABLET"));
		Assert.assertFalse(this.paginaDePesquisa.isPaginaInicial());
		paginaDePesquisa.fechar();
	}
	
	@Quando("pesquisa um produto que nao existe")
	public void pesquisa_um_produto_que_nao_existe() throws InterruptedException {
		this.paginaDePesquisa = this.paginaInicial.pesquisarProduto("watch");
	}

	@Entao("o produto nao eh encontrado")
	public void o_produto_nao_eh_encontrado() {
		Assert.assertTrue(this.paginaDePesquisa.mensagemDeProdutoNaoEncontrado());
		Assert.assertFalse(this.paginaDePesquisa.isPaginaInicial());
		paginaDePesquisa.fechar();
	}

}
