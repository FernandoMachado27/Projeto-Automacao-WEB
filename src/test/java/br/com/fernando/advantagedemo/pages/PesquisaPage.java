package br.com.fernando.advantagedemo.pages;

import org.openqa.selenium.WebDriver;

import br.com.fernando.advantagedemo.Browser;

public class PesquisaPage extends Browser{

	public PesquisaPage(WebDriver browser) {
		super(browser);
	}

	public boolean contemProdutoPesquisado(String product) {
		return browser.getPageSource().contains(product);
	}


	public boolean mensagemDeProdutoNaoEncontrado() {
		return browser.getPageSource().contains("No results for \"watch\"");
	}

	public boolean isPaginaInicial() {
		return browser.getCurrentUrl().equals(URL_INICIAL);
	}

}
